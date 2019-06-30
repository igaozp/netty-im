package hanzo.client;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import hanzo.client.console.ConsoleCommandManager;
import hanzo.client.console.LoginConsoleCommand;
import hanzo.client.handler.*;
import hanzo.codec.PacketDecoder;
import hanzo.codec.PacketEncoder;
import hanzo.codec.Spliter;
import hanzo.handler.IMIdleStateHandler;
import hanzo.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * NettyClient
 *
 * @author igaozp
 */
public class NettyClient {
    private final static int MAX_RETRY = 5;
    private final static String HOST = "127.0.0.1";
    private final static int PORT = 8000;
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("console-pool-%d").build();
    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory);

    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) {
                        // 空闲检测
                        channel.pipeline().addLast(new IMIdleStateHandler());
                        // 粘包拆包处理器
                        channel.pipeline().addLast(new Spliter());
                        // 协议包解码器
                        channel.pipeline().addLast(new PacketDecoder());
                        // 登录响应处理器
                        channel.pipeline().addLast(new LoginResponseHandler());
                        // 消息响应处理器
                        channel.pipeline().addLast(new MessageResponseHandler());
                        // 创建群聊响应处理器
                        channel.pipeline().addLast(new CreateGroupResponseHandler());
                        // 加入群组响应处理器
                        channel.pipeline().addLast(new JoinGroupResponseHandler());
                        // 退出群组响应处理器
                        channel.pipeline().addLast(new QuitGroupResponseHandler());
                        // 获取小组成员响应处理器
                        channel.pipeline().addLast(new ListGroupMembersResponseHandler());
                        // 群消息响应处理器
                        channel.pipeline().addLast(new GroupMessageResponseHandler());
                        // 用户登出响应处理器
                        channel.pipeline().addLast(new LogoutResponseHandler());
                        // 协议包编码器
                        channel.pipeline().addLast(new PacketEncoder());
                        // 心跳定时器
                        channel.pipeline().addLast(new HeartBeatTimerHandler());
                    }
                });

        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功，启动控制台线程");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + "：连接失败，第 " + order + " 次重连");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        singleThreadPool.execute(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        });
        singleThreadPool.shutdown();
    }
}

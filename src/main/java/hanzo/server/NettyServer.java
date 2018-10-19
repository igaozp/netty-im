package hanzo.server;

import hanzo.codec.PacketCodecHandler;
import hanzo.codec.PacketDecoder;
import hanzo.codec.PacketEncoder;
import hanzo.codec.Spliter;
import hanzo.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/**
 * NettyServer
 *
 * @author igaozp
 */
public class NettyServer {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(new Spliter());
                        channel.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        channel.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        channel.pipeline().addLast(AuthHandler.INSTANCE);
                        channel.pipeline().addLast(IMHandler.INSTANCE);
                    }
                });
        bind(serverBootstrap);
    }

    private static void bind(final ServerBootstrap serverBootstrap) {
        serverBootstrap.bind(NettyServer.PORT).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口【" + NettyServer.PORT + "】绑定成功!");
            } else {
                System.out.println("端口【" + NettyServer.PORT + "】绑定失败");
            }
        });
    }
}

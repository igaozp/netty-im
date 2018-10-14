package hanzo.client.handler;

import hanzo.protocol.response.LoginResponsePacket;
import hanzo.session.Session;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LoginResponseHandler
 *
 * @author igaozp
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, LoginResponsePacket loginResponsePacket) {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            System.out.println("【" + userName + "】登录成功，userId 为：" + loginResponsePacket.getUserId());
            SessionUtil.bindSession(new Session(userId, userName), context.channel());
        } else {
            System.out.println("【" + userName + "】登录失败，原因: " + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭！");
    }
}

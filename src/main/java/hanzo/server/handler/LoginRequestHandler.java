package hanzo.server.handler;

import hanzo.protocol.request.LoginRequestPacket;
import hanzo.protocol.response.LoginResponsePacket;
import hanzo.session.Session;
import hanzo.util.IDUtil;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * LoginRequestHandler
 *
 * @author igaozp
 */
@NoArgsConstructor
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext context, LoginRequestPacket loginRequestPacket) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUsername());

        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            String userId = IDUtil.randomId();
            loginResponsePacket.setUserId(userId);
            System.out.println("【" + loginRequestPacket.getUsername() + "】登录成功");
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), context.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败！");
        }

        // 登录响应
        context.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}

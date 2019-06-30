package hanzo.server.handler;

import hanzo.protocol.request.LogoutRequestPacket;
import hanzo.protocol.response.LogoutResponsePacket;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.NoArgsConstructor;

/**
 * LogoutRequestHandler
 *
 * @author igaozp
 */
@NoArgsConstructor
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext context, LogoutRequestPacket msg) {
        SessionUtil.unBindSession(context.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        context.channel().writeAndFlush(logoutResponsePacket);
    }
}

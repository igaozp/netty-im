package hanzo.server.handler;

import hanzo.protocol.request.LogoutRequestPacket;
import hanzo.protocol.response.LogoutResponsePacket;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LogoutRequestHandler
 *
 * @author igaozp
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, LogoutRequestPacket msg) {
        SessionUtil.unBindSession(context.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        context.channel().writeAndFlush(logoutResponsePacket);
    }
}

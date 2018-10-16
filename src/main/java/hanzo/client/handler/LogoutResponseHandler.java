package hanzo.client.handler;

import hanzo.protocol.response.LogoutResponsePacket;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LogoutResponseHandler
 *
 * @author igaozp
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, LogoutResponsePacket logoutResponsePacket) {
        SessionUtil.unBindSession(context.channel());
    }
}

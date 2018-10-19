package hanzo.client.handler;

import hanzo.protocol.response.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * JoinGroupResponseHandler
 *
 * @author igaozp
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, JoinGroupResponsePacket responsePacket) {
        if (responsePacket.isSuccess()) {
            System.out.println("加入群【" + responsePacket.getGroupId() + "】成功");
        } else {
            System.out.println("加入群【" + responsePacket.getGroupId() + "】失败，原因为：" + responsePacket.getReason());
        }
    }
}

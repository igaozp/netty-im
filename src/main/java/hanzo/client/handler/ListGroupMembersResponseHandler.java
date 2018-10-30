package hanzo.client.handler;

import hanzo.protocol.response.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ListGroupMembersResponseHandler
 *
 * @author igaozp
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersResponsePacket responsePacket) {
        System.out.println("群【" + responsePacket.getGroupId() + "】中的人包括：" + responsePacket.getSessionList());
    }
}
package hanzo.client.handler;

import hanzo.protocol.response.GroupMessageResponsePacket;
import hanzo.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * GroupMessageResponseHandler
 *
 * @author igaozp
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket groupMessageResponsePacket) {
        String fromGroupId = groupMessageResponsePacket.getFromGroupId();
        Session fromUser = groupMessageResponsePacket.getFromUser();
        System.out.println("收到群【" + fromGroupId + "】中【" + fromUser + "】发来的消息：" + groupMessageResponsePacket.getMessage());
    }
}

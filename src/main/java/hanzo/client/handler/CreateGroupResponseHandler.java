package hanzo.client.handler;

import hanzo.protocol.response.CreateGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * CreateGroupResponseHandler
 *
 * @author igaozp
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupResponsePacket createGroupResponsePacket) {
        System.out.println("群创建成功，id 为【" + createGroupResponsePacket.getGroupId() + "】");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
    }
}

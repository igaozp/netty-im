package hanzo.server.handler;

import hanzo.protocol.request.QuitGroupRequestPacket;
import hanzo.protocol.response.QuitGroupResponsePacket;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * QuitGroupRequestHandler
 *
 * @author igaozp
 */
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {
    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    public QuitGroupRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, QuitGroupRequestPacket requestPacket) {
        // 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(context.channel());

        // 构造退群响应发送给客户端
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setGroupId(requestPacket.getGroupId());
        responsePacket.setSuccess(true);

        context.channel().writeAndFlush(responsePacket);
    }
}

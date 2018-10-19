package hanzo.server.handler;

import hanzo.protocol.request.JoinGroupRequestPacket;
import hanzo.protocol.response.JoinGroupResponsePacket;
import hanzo.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * JoinGroupRequestHandler
 *
 * @author igaozp
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    public JoinGroupRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, JoinGroupRequestPacket requestPacket) {
        // 将当前 Channel 加入到群聊的 Channel 分组中
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(context.channel());

        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(groupId);

        context.channel().writeAndFlush(responsePacket);
    }
}

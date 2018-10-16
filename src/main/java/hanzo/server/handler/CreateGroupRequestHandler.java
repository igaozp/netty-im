package hanzo.server.handler;

import hanzo.protocol.request.CreateGroupRequestPacket;
import hanzo.protocol.response.CreateGroupResponsePacket;
import hanzo.util.IDUtil;
import hanzo.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateGroupRequestHandler
 *
 * @author igaozp
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, CreateGroupRequestPacket createGroupRequestPacket) {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();
        List<String> userNameList = new ArrayList<>();

        // 创建 Channel 分组
        ChannelGroup channelGroup = new DefaultChannelGroup(context.executor());

        // 将群聊用户的 Channel 加入 Channel 分组
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 构造创建群聊的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IDUtil.randomId());
        createGroupResponsePacket.setUserNameList(userNameList);

        // 发送创建群聊的通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.println("群创建成功，ID 为 " + createGroupResponsePacket.getGroupId() + ", ");
        System.out.println("群成员有：" + createGroupResponsePacket.getUserNameList());
    }
}

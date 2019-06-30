package hanzo.server.handler;

import hanzo.protocol.request.MessageRequestPacket;
import hanzo.protocol.response.MessageResponsePacket;
import hanzo.session.Session;
import hanzo.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.NoArgsConstructor;

/**
 * MessageRequestHandler
 *
 * @author igaozp
 */
@NoArgsConstructor
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext context, MessageRequestPacket messageRequestPacket) {
        // 获取消息发送方的会话信息
        Session session = SessionUtil.getSession(context.channel());

        // 构造响应信息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        // 获取接受方的 Channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        // 返回信息给发送方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.out.println("【" + session.getUserId() + "】不在线，发送失败");
        }
    }
}

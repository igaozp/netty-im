package hanzo.server.handler;

import hanzo.protocol.BasePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

import static hanzo.protocol.command.Command.*;

/**
 * IMHandler
 *
 * @author igaozp
 */
@ChannelHandler.Sharable
public class IMHandler extends SimpleChannelInboundHandler<BasePacket> {
    public static final IMHandler INSTANCE = new IMHandler();
    private Map<Byte, SimpleChannelInboundHandler<? extends BasePacket>> handlerMap;

    private IMHandler() {
        handlerMap = new HashMap<>();
        handlerMap.put(MESSAGE_REQUEST, MessageRequestHandler.INSTANCE);
        handlerMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestHandler.INSTANCE);
        handlerMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestHandler.INSTANCE);
        handlerMap.put(QUIT_GROUP_REQUEST, QuitGroupRequestHandler.INSTANCE);
        handlerMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestHandler.INSTANCE);
        handlerMap.put(GROUP_MESSAGE_REQUEST, GroupMessageRequestHandler.INSTANCE);
        handlerMap.put(LOGOUT_REQUEST, LogoutRequestHandler.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, BasePacket packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(context, packet);
    }
}

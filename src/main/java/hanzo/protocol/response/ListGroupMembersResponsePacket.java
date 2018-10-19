package hanzo.protocol.response;

import hanzo.protocol.Packet;
import hanzo.session.Session;
import lombok.Data;

import java.util.List;

import static hanzo.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * ListGroupMembersResponsePacket
 *
 * @author igaozp
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {
    private String groupId;
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}

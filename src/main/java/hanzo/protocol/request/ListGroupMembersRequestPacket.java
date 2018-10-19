package hanzo.protocol.request;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * ListGroupMembersRequestPacket
 *
 * @author igaozp
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {
    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}

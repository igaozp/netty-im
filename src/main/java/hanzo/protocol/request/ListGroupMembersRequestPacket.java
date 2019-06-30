package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * ListGroupMembersRequestPacket
 *
 * @author igaozp
 */
@Data
public class ListGroupMembersRequestPacket extends BasePacket {
    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}

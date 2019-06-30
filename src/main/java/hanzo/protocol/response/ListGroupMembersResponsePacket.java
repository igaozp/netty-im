package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import hanzo.session.Session;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import static hanzo.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * ListGroupMembersResponsePacket
 *
 * @author igaozp
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListGroupMembersResponsePacket extends BasePacket {
    private String groupId;
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}

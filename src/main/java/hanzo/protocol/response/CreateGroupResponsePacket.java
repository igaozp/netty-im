package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import java.util.List;

import static hanzo.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * CreateGroupResponsePacket
 *
 * @author igaozp
 */
@Data
public class CreateGroupResponsePacket extends BasePacket {
    private boolean success;
    private String groupId;
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}

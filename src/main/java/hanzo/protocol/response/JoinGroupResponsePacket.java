package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * JoinGroupResponsePacket
 *
 * @author igaozp
 */
@Data
public class JoinGroupResponsePacket extends BasePacket {
    private String groupId;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}

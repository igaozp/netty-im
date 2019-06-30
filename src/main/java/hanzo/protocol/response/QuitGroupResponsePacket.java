package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * QuitGroupResponsePacket
 *
 * @author igaozp
 */
@Data
public class QuitGroupResponsePacket extends BasePacket {
    private String groupId;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}

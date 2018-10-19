package hanzo.protocol.response;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * QuitGroupResponsePacket
 *
 * @author igaozp
 */
@Data
public class QuitGroupResponsePacket extends Packet {
    private String groupId;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}

package hanzo.protocol.request;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * GroupMessageRequestPacket
 *
 * @author igaozp
 */
@Data
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}

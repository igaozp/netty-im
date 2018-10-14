package hanzo.protocol.request;

import hanzo.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static hanzo.protocol.command.Command.MESSAGE_REQUEST;

/**
 * MessageRequestPacket
 *
 * @author igaozp
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}

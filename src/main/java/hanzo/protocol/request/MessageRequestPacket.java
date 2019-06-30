package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static hanzo.protocol.command.Command.MESSAGE_REQUEST;

/**
 * MessageRequestPacket
 *
 * @author igaozp
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MessageRequestPacket extends BasePacket {
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

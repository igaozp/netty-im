package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static hanzo.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * MessageResponsePacket
 *
 * @author igaozp
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MessageResponsePacket extends BasePacket {
    private String fromUserId;
    private String fromUserName;
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}

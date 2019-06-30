package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * MessageResponsePacket
 *
 * @author igaozp
 */
@Data
public class MessageResponsePacket extends BasePacket {
    private String fromUserId;
    private String fromUserName;
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}

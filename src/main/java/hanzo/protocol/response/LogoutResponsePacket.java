package hanzo.protocol.response;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * LogoutResponsePacket
 *
 * @author igaozp
 */
@Data
public class LogoutResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}

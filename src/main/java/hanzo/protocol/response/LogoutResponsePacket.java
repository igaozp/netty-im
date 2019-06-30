package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * LogoutResponsePacket
 *
 * @author igaozp
 */
@Data
public class LogoutResponsePacket extends BasePacket {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}

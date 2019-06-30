package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGOUT_REQUEST;

/**
 * LogoutRequestPacket
 *
 * @author igaozp
 */
@Data
public class LogoutRequestPacket extends BasePacket {
    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}

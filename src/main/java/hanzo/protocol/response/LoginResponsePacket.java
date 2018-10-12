package hanzo.protocol.response;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGIN_RESPONSE;

/**
 * LoginResponsePacket
 *
 * @author igaozp
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}

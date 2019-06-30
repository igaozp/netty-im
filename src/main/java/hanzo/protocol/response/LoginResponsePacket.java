package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGIN_RESPONSE;

/**
 * LoginResponsePacket
 *
 * @author igaozp
 */
@Data
public class LoginResponsePacket extends BasePacket {
    private String userId;
    private String userName;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}

package hanzo.protocol.response;

import hanzo.protocol.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static hanzo.protocol.command.Command.LOGIN_RESPONSE;

/**
 * LoginResponsePacket
 *
 * @author igaozp
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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

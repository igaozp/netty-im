package hanzo.protocol.request;

import hanzo.protocol.Packet;
import lombok.Data;

import static hanzo.protocol.command.Command.LOGIN_REQUEST;

/**
 * LoginRequestPacket
 *
 * @author igaozp
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}

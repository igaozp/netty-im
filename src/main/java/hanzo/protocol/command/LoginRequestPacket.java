package hanzo.protocol.command;

import lombok.Data;

import static hanzo.protocol.command.Command.LOGIN_REQUEST;

/**
 * LoginRequestPacket
 *
 * @author igaozp
 */
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}

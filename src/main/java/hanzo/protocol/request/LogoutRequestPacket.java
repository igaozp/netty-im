package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static hanzo.protocol.command.Command.LOGOUT_REQUEST;

/**
 * LogoutRequestPacket
 *
 * @author igaozp
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LogoutRequestPacket extends BasePacket {
    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}

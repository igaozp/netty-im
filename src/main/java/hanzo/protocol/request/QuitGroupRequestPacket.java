package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static hanzo.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * QuitGroupRequestPacket
 *
 * @author igaozp
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QuitGroupRequestPacket extends BasePacket {
    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}

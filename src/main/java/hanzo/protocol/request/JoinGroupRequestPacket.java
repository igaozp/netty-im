package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;

import static hanzo.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * JoinGroupRequestPacket
 *
 * @author igaozp
 */
@Data
public class JoinGroupRequestPacket extends BasePacket {
    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}

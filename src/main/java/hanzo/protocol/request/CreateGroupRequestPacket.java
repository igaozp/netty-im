package hanzo.protocol.request;

import hanzo.protocol.BasePacket;
import lombok.Data;

import java.util.List;

import static hanzo.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * CreateGroupRequestPacket
 *
 * @author igaozp
 */
@Data
public class CreateGroupRequestPacket extends BasePacket {
    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}

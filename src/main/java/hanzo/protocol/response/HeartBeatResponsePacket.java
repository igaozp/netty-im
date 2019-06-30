package hanzo.protocol.response;

import hanzo.protocol.BasePacket;

import static hanzo.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * HeartBeatResponsePacket
 *
 * @author igaozp
 */
public class HeartBeatResponsePacket extends BasePacket {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}

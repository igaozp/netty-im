package hanzo.protocol.request;

import hanzo.protocol.BasePacket;

import static hanzo.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * HeartBeatRequestPacket
 *
 * @author igaozp
 */
public class HeartBeatRequestPacket extends BasePacket {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}

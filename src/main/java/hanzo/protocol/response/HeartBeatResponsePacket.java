package hanzo.protocol.response;

import hanzo.protocol.Packet;

import static hanzo.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * HeartBeatResponsePacket
 *
 * @author igaozp
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}

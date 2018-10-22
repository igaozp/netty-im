package hanzo.protocol.request;

import hanzo.protocol.Packet;

import static hanzo.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * HeartBeatRequestPacket
 *
 * @author igaozp
 */
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}

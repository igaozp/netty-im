package hanzo.codec;

import hanzo.protocol.Packet;
import hanzo.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * PacketEncoder
 *
 * @author igaozp
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext context, Packet packet, ByteBuf byteBuf) {
        PacketCodec.INSTANCE.encode(byteBuf, packet);
    }
}

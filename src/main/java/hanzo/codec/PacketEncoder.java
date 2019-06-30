package hanzo.codec;

import hanzo.protocol.BasePacket;
import hanzo.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * PacketEncoder
 *
 * @author igaozp
 */
public class PacketEncoder extends MessageToByteEncoder<BasePacket> {
    @Override
    protected void encode(ChannelHandlerContext context, BasePacket packet, ByteBuf byteBuf) {
        PacketCodec.INSTANCE.encode(byteBuf, packet);
    }
}

package hanzo.protocol.command;

import hanzo.protocol.Packet;
import hanzo.protocol.PacketCodec;
import hanzo.protocol.request.LoginRequestPacket;
import hanzo.serialize.Serializer;
import hanzo.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * PacketCodecTest
 *
 * @author igaozp
 */
public class PacketCodecTest {
    @Test
    public void encode() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion((byte) 1);
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("carpe");
        loginRequestPacket.setPassword("diem");

        PacketCodec packetCodec = PacketCodec.INSTANCE;
        ByteBuf byteBuf = packetCodec.encode(ByteBufAllocator.DEFAULT, loginRequestPacket);
        Packet decodePacket = packetCodec.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodePacket));
    }
}

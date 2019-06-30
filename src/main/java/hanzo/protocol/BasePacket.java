package hanzo.protocol;

import lombok.Data;

/**
 * BasePacket
 *
 * @author igaozp
 */
@Data
public abstract class BasePacket {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 获取指令
     *
     * @return 指令
     */
    public abstract Byte getCommand();
}

package hanzo.serialize;

import hanzo.serialize.impl.JSONSerializer;

/**
 * Serializer
 *
 * @author igaozp
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 获取序列化算法
     *
     * @return 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * 将对象序列化
     *
     * @param object 对象
     * @return 二进制数组
     */
    byte[] serialize(Object object);

    /**
     * 反序列化
     *
     * @param clazz 对象
     * @param bytes 二进制数据
     * @param <T>   泛型
     * @return 反序列化后的对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}

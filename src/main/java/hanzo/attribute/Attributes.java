package hanzo.attribute;

import io.netty.util.AttributeKey;

/**
 * Attributes
 *
 * @author igaozp
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}

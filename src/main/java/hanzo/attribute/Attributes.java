package hanzo.attribute;

import hanzo.session.Session;
import io.netty.util.AttributeKey;

/**
 * Attributes
 *
 * @author igaozp
 */
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}

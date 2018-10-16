package hanzo.util;

import java.util.UUID;

/**
 * IDUtil
 *
 * @author igaozp
 */
public class IDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}

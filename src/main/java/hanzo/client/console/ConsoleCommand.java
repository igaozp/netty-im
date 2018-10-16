package hanzo.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * ConsoleCommand
 *
 * @author igaozp
 */
public interface ConsoleCommand {
    /**
     * 执行控制台命令
     *
     * @param scanner scanner
     * @param channel channel
     */
    void exec(Scanner scanner, Channel channel);
}

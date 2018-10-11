package hanzo.protocol.response;

import hanzo.protocol.Packet;

import static hanzo.protocol.command.Command.LOGIN_RESPONSE;

/**
 * LoginResponsePacket
 *
 * @author igaozp
 */
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

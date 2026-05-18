package mc.sbm.operaconductor.service;

import java.io.Serial;

public class UsernameAlreadyUsedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /** Creates a new UsernameAlreadyUsedException with a default message. */
    public UsernameAlreadyUsedException() {
        super("Login name already used!");
    }
}

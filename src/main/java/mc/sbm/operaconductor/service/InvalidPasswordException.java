package mc.sbm.operaconductor.service;

import java.io.Serial;

public class InvalidPasswordException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /** Creates a new InvalidPasswordException with a default message. */
    public InvalidPasswordException() {
        super("Incorrect password");
    }
}

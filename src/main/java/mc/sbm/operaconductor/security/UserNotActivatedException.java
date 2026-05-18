package mc.sbm.operaconductor.security;

import java.io.Serial;
import org.springframework.security.core.AuthenticationException;

/**
 * This exception is thrown in case of a not activated user trying to authenticate.
 */
public class UserNotActivatedException extends AuthenticationException {

    @Serial
    private static final long serialVersionUID = 1L;

    /** Creates a new UserNotActivatedException with the given message. */
    public UserNotActivatedException(String message) {
        super(message);
    }

    /** Creates a new UserNotActivatedException with the given message and cause. */
    public UserNotActivatedException(String message, Throwable t) {
        super(message, t);
    }
}

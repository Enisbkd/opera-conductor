package mc.sbm.operaconductor.web.rest.vm;

import jakarta.validation.constraints.Size;
import mc.sbm.operaconductor.service.dto.AdminUserDTO;

/**
 * View Model extending the AdminUserDTO, which is meant to be used in the user management UI.
 */
public class ManagedUserVM extends AdminUserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    /** Creates a new empty ManagedUserVM (required by Jackson). */
    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    /** Returns the password. */
    public String getPassword() {
        return password;
    }

    /** Sets the password. */
    public void setPassword(String password) {
        this.password = password;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ManagedUserVM{" + super.toString() + "} ";
    }
}

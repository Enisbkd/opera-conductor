package mc.sbm.operaconductor.service.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * A DTO representing a password change required data - current and new password.
 */
public class PasswordChangeDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String currentPassword;
    private String newPassword;

    /** Creates a new empty PasswordChangeDTO (required by Jackson). */
    public PasswordChangeDTO() {
        // Empty constructor needed for Jackson.
    }

    /** Creates a PasswordChangeDTO with the given current and new passwords. */
    public PasswordChangeDTO(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

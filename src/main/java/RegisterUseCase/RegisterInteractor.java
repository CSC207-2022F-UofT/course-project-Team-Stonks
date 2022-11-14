package RegisterUseCase;

import entities.EntityHolder;
import entities.UserManager;

import java.sql.Date;

public class RegisterInteractor {
    private UserManager userManager;
    private final int VALID_PASS_LENGTH = 8;

    public RegisterInteractor() {
        userManager = EntityHolder.instance.getUserManager();
    }

    public RegisterError signUpUser(String username, String password, String passwordConfirm, Date loginDate) {
        if (userManager.userExists(username)) {
            return RegisterError.USERNAME;
        }else if (!password.equals(passwordConfirm)) {
            return RegisterError.PASSWORD_NOT_MATCH;
        } else if (!passwordValid(password)) {
            return RegisterError.PASSWORD_INVALID;
        }

        userManager.createUser(username, password, loginDate);

        return RegisterError.NONE;
    }

    public boolean passwordValid(String password) {
        return password.length() >= VALID_PASS_LENGTH;
    }
}
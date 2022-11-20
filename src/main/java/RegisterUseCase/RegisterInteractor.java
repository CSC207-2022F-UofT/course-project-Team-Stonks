package RegisterUseCase;

import entities.EntityHolder;
import entities.UserManager;

import java.sql.Date;

public class RegisterInteractor {
    private final UserManager userManager;
    private final int VALID_PASS_LENGTH = 8;

    public RegisterInteractor() {
        userManager = EntityHolder.instance.getUserManager();
    }

    public RegisterError signUpUser(String username, String password, String passwordConfirm, Date loginDate) {
        if (usernameValid(username)) {
            return RegisterError.USERNAME;
        }else if (passwordMatch(password, passwordConfirm)) {
            return RegisterError.PASSWORD_NOT_MATCH;
        } else if (!passwordValid(password)) {
            return RegisterError.PASSWORD_INVALID;
        }

        userManager.createUser(username, password, loginDate);

        return RegisterError.NONE;
    }


    public boolean usernameValid(String username) {
        return userManager.userExists(username) || username.equals("") || username.contains(" ");
    }
    public boolean passwordValid(String password) {

        return password.length() >= VALID_PASS_LENGTH;
    }

    public boolean passwordMatch(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

}
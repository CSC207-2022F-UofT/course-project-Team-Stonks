package RegisterUseCase;

import entities.EntityHolder;
import entities.UserManager;

import java.sql.Date;

public class RegisterInteractor {
    private final UserManager userManager;

    /**
     *
     */
    public RegisterInteractor() {
        userManager = EntityHolder.instance.getUserManager();
    }

    /**
     * @param username
     * @param password
     * @param passwordConfirm
     * @param loginDate
     * @return RegisterError type such that it can be a Username or Password error or no error
     */

    public RegisterError signUpUser(String username, String password, String passwordConfirm, Date loginDate) {

        // Refactored by adding methods to check for errors in order to make the code more readable
        if (usernameInvalid(username)) {
            return RegisterError.USERNAME;
        } else if (!passwordValid(password)) {
            return RegisterError.PASSWORD_INVALID;
        }else if (!passwordMatch(password, passwordConfirm)) {
            return RegisterError.PASSWORD_NOT_MATCH;
        }
        else {
            userManager.createUser(username, password, loginDate);
            return RegisterError.NONE;
        }
    }


    /**
     * @param username
     * @return True if the username is invalid
     * Refactored
     */
    private boolean usernameInvalid(String username) {
        // case 1: username is already taken, case 2: username is empty, case 3: username contains spaces
        // case 4: username is too long (SQL Error)
        return userManager.userExists(username) || username.equals("") || username.contains(" ") || username.length() > 50 ;
    }

    /**
     * @param password
     * @return True if password length is greater than or equal to 8, false otherwise
     */
    private boolean passwordValid(String password) {
        int VALID_PASS_LENGTH = 8;
        return password.length() >= VALID_PASS_LENGTH;
    }

    /**
     * @param password
     * @param passwordConfirm
     * @return True if password and passwordConfirm match, else false
     */
    private boolean passwordMatch(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }
}
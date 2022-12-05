package LoginUseCase;

import entities.User;
import entities.UserManager;

import java.sql.Date;

/**
 * This class is the use case interactor for the login
 * which contains one method that gets user from the
 * user manager based on given input
 */
public class UserLoginInteractor {
    private final UserManager userManager;

    public UserLoginInteractor() {
        userManager = UserManager.instance;
    }

    public User loginUser(String username, String password, Date loginDate) {
         return userManager.getUser(username, password, loginDate);
    }
}
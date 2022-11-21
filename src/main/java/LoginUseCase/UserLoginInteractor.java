package LoginUseCase;

import entities.User;
import entities.UserManager;

import java.sql.Date;

public class UserLoginInteractor {
    private final UserManager userManager;

    public UserLoginInteractor() {
        userManager = UserManager.instance;
    }

    public User loginUser(String username, String password, Date loginDate) {
         return userManager.getUser(username, password, loginDate);
    }
}
package LoginUseCase;

import entities.EntityHolder;
import entities.User;
import entities.UserManager;

import java.sql.Date;

public class UserLoginInteractor {
    private UserManager userManager;

    public UserLoginInteractor() {
        userManager = EntityHolder.instance.getUserManager();
    }

    public User loginUser(String username, String password, Date loginDate) {
         return userManager.getUser(username, password, loginDate);
    }
}
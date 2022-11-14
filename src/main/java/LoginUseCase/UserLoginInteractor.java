package LoginUseCase;

import db.EntitySQLGateway;
import entities.EntityHolder;
import entities.User;
import entities.UserManager;

import java.sql.Date;

public class UserLoginInteractor {
    private UserManager userManager;

    public UserLoginInteractor() {
        userManager = EntityHolder.instance.getUserManager();
    }

    public UserLoginResponse loginUser(String username, String password, Date loginDate) {
         return new UserLoginResponse(
                 userManager.getUser(username, password, loginDate));
    }
}
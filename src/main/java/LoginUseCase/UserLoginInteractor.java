package LoginUseCase;

import db.EntitySQLGateway;
import entities.User;
import entities.UserManager;

import java.sql.Date;

public class UserLoginInteractor {
    private UserManager userManager;
    private UserLoginPresenter presenter;

    public UserLoginInteractor() {
        userManager = new UserManager(new EntitySQLGateway());
    }

    public UserLoginResponse loginUser(String username, String password, Date loginDate) {
         return new UserLoginResponse(
                 userManager.getUser(username, password, loginDate));
    }
}
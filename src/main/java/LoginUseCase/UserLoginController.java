package LoginUseCase;

import java.sql.Date;

public class UserLoginController {
    private UserLoginInteractor interactor;

    public UserLoginController() {
        interactor = new UserLoginInteractor();
    }

    public UserLoginResponse loginUser(UserLoginRequest request) {
        return interactor.loginUser(request.username(), request.password(), request.loginDate());
    }

}
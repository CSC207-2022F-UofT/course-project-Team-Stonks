package LoginUseCase;

import PortfolioCreationUseCase.UserPresenter;
import RegisterUseCase.RegisterPresenter;
import entities.User;
import main.OuterLayerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserLoginPresenter {
    private iUserLoginGUI view;
    private UserLoginController controller;

    public UserLoginPresenter(iUserLoginGUI view) {
        this.view = view;
        controller = new UserLoginController();

        view.addLoginAction(this::onLogin);
        view.addSignUpAction(this::onSignUp);
    }

    private void onLogin() {
        UserLoginRequest request = new UserLoginRequest(
                view.getUsername(),
                view.getPassword(),
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);

        loginResult(response);
    }

    private void onSignUp() {
        view.close();
        new RegisterPresenter(OuterLayerFactory.instance.getRegisterGUI());
    }

    private void loginResult(UserLoginResponse response) {
        User user = response.user();

        if (user == null) {
            view.presentFailedLogin();
        } else {
            view.close();
            new UserPresenter(
                    OuterLayerFactory.instance.getUserGUI(
                            user.getUsername(),
                            new ArrayList<>(user.getPortfolioNames()),
                            user.getLastLogin()),
                    user);
        }
    }
}
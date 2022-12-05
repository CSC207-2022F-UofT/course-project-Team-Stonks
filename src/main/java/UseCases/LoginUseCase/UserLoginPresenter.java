package UseCases.LoginUseCase;

import Controllers.UserLoginController;
import UseCases.PortfolioCreationUseCase.UserPresenter;
import UseCases.RegisterUseCase.RegisterPresenter;
import entities.User;
import main.OuterLayerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class is responsible for controlling the logic of
 * the user login view
 */
public class UserLoginPresenter {
    private final UserLoginView view;
    private final UserLoginController controller;


    /**
     * @param view not-null input
     * Initializes the presenter and adds button action observers
     */
    public UserLoginPresenter(UserLoginView view) {
        this.view = view;
        controller = new UserLoginController();

        view.addLoginAction(this::onLogin);
        view.addSignUpAction(this::onSignUp);
    }


    /**
     * Contains logic for when the user clicks on the login button
     */
    private void onLogin() {
        UserLoginRequest request = new UserLoginRequest(
                view.getUsername(),
                view.getPassword(),
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);

        loginResult(response);
    }

    /**
     * Contains logic for when the user clicks on the sign-up button
     */
    private void onSignUp() {
        view.close();
        new RegisterPresenter(OuterLayerFactory.instance.getRegisterGUI());
    }

    /**
     * Contains logic for what the view should display after
     * a response object is received from the controller, weather
     * login was successful or not
     */
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
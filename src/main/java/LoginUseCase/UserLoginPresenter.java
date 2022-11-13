package LoginUseCase;

import PortfolioCreationUseCase.PortfolioCreationPresenter;
import PortfolioCreationUseCase.UserGUI;
import entities.User;
import main.OuterLayerFactory;
import main.StockSimulator;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserLoginPresenter {
    private iUserLoginGUI view;
    private UserLoginController controller;

    public UserLoginPresenter(iUserLoginGUI view) {
        this.view = view;
        controller = new UserLoginController();

        view.addLoginAction(() -> onLogin());
        view.addSignUpAction(() -> onSignUp());
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
        new UserLoginGUI();
    }

    private void loginResult(UserLoginResponse response) {
        User user = response.user();

        if (user == null) {
            view.presentFailedLogin();
        } else {
            view.close();
            new PortfolioCreationPresenter(
                    OuterLayerFactory.instance.getUserGUI(
                            user.getUsername(),
                            new ArrayList<>(user.getPortfolioNames()),
                            user.getLastLogin()),
                    user);
        }
    }


}
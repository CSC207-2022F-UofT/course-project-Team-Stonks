package LoginUseCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class UserLoginPresenter implements iUserLoginPresenter {
    private UserLoginGUI view;
    private UserLoginController controller;

    public UserLoginPresenter() {
        view = new UserLoginGUI();
        controller = new UserLoginController();

        view.getLoginBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });

        view.getSignUpBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSignUp();
            }
        });
    }

    public void onLogin() {
        UserLoginRequest request = new UserLoginRequest(
                view.getUsernameText().getText(),
                String.valueOf(view.getPasswordField().getPassword()),
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);

        loginResult(response);
    }

    public void onSignUp() {
        JFrame registerGUI = new UserLoginGUI();
        view.onCancel();
    }

    public void loginResult(UserLoginResponse response) {
        if (response.user() == null) {
            view.showFailedLogin();
        } else {
            view.showSuccessLogin(response.user().getUsername());
            //view.onCancel();
        }
    }


}
package RegisterUseCase;

import LoginUseCase.*;
import main.OuterLayerFactory;

import java.sql.Date;
import java.time.LocalDate;

public class RegisterPresenter {
    private iRegisterGUI view;
    private RegisterController controller;

    public RegisterPresenter(iRegisterGUI view) {
        this.view = view;
        controller = new RegisterController();

        view.addRegisterAction(this::onRegister);
        view.addBackAction(this::onBack);
    }

    private void onRegister() {
        RegisterRequest request = new RegisterRequest(
                view.getUsername(),
                view.getPassword(),
                view.getPasswordConfirm(),
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);

        switch (response.userSignedUp()){
            case USERNAME -> view.presentUsernameError();
            case PASSWORD_INVALID -> view.presentPasswordInvalidError();
            case PASSWORD_NOT_MATCH -> view.presentPasswordNotMatchError();
            default -> onBack();
        }
    }

    private void onBack() {
        view.close();
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());

    }
}
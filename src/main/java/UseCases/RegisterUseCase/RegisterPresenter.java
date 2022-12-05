package UseCases.RegisterUseCase;

import UseCases.LoginUseCase.UserLoginPresenter;
import main.OuterLayerFactory;

import java.sql.Date;
import java.time.LocalDate;

public class RegisterPresenter {
    private final iRegisterGUI view;
    private final RegisterController controller;

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
        RegisterError userSignedUp = response.userSignedUp();

        if (userSignedUp == RegisterError.USERNAME) {
            view.presentUsernameError();
        } else if (userSignedUp == RegisterError.PASSWORD_INVALID) {
            view.presentPasswordInvalidError();
        } else if (userSignedUp == RegisterError.PASSWORD_NOT_MATCH) {
            view.presentPasswordNotMatchError();
        } else {
            onBack();
        }
    }

    private void onBack() {
        view.close();
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());
    }
}
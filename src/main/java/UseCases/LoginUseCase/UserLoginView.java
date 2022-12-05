package UseCases.LoginUseCase;

public interface UserLoginView {

    /**
     * This is the interface for the login use case
     * Refactored from LoginUseCase.UserLoginGUI
     */

    String getUsername();

    String getPassword();

    void addLoginAction(Runnable onLogin);

    void addSignUpAction(Runnable onSignUp);

    void close();

    void presentFailedLogin();
}
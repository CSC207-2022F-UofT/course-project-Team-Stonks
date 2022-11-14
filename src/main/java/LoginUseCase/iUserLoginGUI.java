package LoginUseCase;

public interface iUserLoginGUI {
    String getUsername();

    String getPassword();

    void addLoginAction(Runnable onLogin);

    void addSignUpAction(Runnable onSignUp);

    void close();

    void presentFailedLogin();
}
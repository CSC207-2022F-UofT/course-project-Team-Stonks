package RegisterUseCase;

public interface iRegisterGUI {
    String getUsername();

    String getPassword();

    String getPasswordConfirm();

    void addRegisterAction(Runnable onSignUp);

    void addBackAction(Runnable onLogin);

    void presentUsernameError();

    void presentPasswordInvalidError();

    void presentPasswordNotMatchError();

    void close();
}
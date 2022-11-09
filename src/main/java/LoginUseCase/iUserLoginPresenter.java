package LoginUseCase;

public interface iUserLoginPresenter {
    void loginResult(UserLoginResponse response);

    void onLogin();

    void onSignUp();
}
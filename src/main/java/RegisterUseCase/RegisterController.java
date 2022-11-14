package RegisterUseCase;

public class RegisterController {
    private RegisterInteractor interactor;

    public RegisterController() {
        interactor = new RegisterInteractor();
    }

    public RegisterResponse signUpUser(RegisterRequest request) {
        RegisterError userSignedUp = interactor.signUpUser(
                request.username(),
                request.password(),
                request.passwordConfirm(),
                request.loginDate());

        return new RegisterResponse(userSignedUp);
    }
}
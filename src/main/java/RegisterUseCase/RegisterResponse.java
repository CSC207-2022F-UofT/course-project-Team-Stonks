package RegisterUseCase;

public final class RegisterResponse {
    private final RegisterError userSignedUp;

    public RegisterResponse(RegisterError userSignedUp) {
        this.userSignedUp = userSignedUp;
    }

    public RegisterError userSignedUp() {
        return userSignedUp;
    }
}
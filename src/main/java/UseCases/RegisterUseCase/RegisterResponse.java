package UseCases.RegisterUseCase;

/**
 * Response model object for when user attempts to register, contains
 * returned user object (could be null)
 */
public record RegisterResponse(RegisterError userSignedUp) {

    /**
     * A getter for the userSignedUp
     *
     * @return RegisterError type of the userSignedUp
     */
    @Override
    public RegisterError userSignedUp() {
        return userSignedUp;
    }
}
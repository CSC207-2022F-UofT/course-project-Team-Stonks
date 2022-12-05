package LoginUseCase;

import entities.User;

/**
 * Response model object for when user attempts to log in, contains
 * returned user object (could be null)
 */
public final class UserLoginResponse {
    private final User user;

    public UserLoginResponse(User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }
}
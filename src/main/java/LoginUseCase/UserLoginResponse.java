package LoginUseCase;

import entities.User;

public final class UserLoginResponse {
    private final User user;

    public UserLoginResponse(User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }
}
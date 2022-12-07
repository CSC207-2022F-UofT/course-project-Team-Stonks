package UseCases.LoginUseCase;

import entities.User;

/**
 * Response model object for when user attempts to log in, contains
 * returned user object (could be null)
 */
public record UserLoginResponse(User user) {
}
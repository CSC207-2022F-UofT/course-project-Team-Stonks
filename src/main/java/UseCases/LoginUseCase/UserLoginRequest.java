package UseCases.LoginUseCase;

import java.sql.Date;

/**
 * Request model object for when user attempts to log in, contains
 * given username, password, and current date
 */
public record UserLoginRequest(String username, String password, Date loginDate) {
}
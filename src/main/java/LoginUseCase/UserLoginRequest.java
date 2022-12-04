package LoginUseCase;

import java.sql.Date;

/**
 * Request model object for when user attempts to log in, contains
 * given username, password, and current date
 */
public final class UserLoginRequest {
    private final String username;
    private final String password;
    private final Date loginDate;

    public UserLoginRequest(String username, String password, Date loginDate) {
        this.username = username;
        this.password = password;
        this.loginDate = loginDate;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public Date loginDate() {
        return loginDate;
    }
}
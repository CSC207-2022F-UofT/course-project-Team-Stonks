package RegisterUseCase;

import java.sql.Date;

public final class RegisterRequest {
    private final String username;
    private final String password;
    private final String passwordConfirm;
    private final Date loginDate;

    public RegisterRequest(String username, String password, String passwordConfirm, Date loginDate) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.loginDate = loginDate;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String passwordConfirm() {
        return passwordConfirm;
    }

    public Date loginDate() {
        return loginDate;
    }
}
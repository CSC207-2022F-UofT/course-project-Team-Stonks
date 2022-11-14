package LoginUseCase;

import java.sql.Date;

public record UserLoginRequest(String username, String password, Date loginDate) {
}
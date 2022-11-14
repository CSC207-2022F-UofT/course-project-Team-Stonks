package RegisterUseCase;

import java.sql.Date;

public record RegisterRequest (String username, String password, String passwordConfirm, Date loginDate){
}
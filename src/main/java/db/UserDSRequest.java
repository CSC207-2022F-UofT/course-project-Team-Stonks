package db;

import java.sql.Date;

public record UserDSRequest(String username, String password, Date lastLogin) {
}
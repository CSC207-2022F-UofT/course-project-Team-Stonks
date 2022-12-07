package db;

import java.sql.Date;

/**
 * Request model class containing input for creating a new user
 * object in the entity database
 */
public record UserDSRequest(String username, String password, Date lastLogin) {
}
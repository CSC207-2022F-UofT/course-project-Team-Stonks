package db;

import java.sql.Date;

public class UserDSRequest {
    private final String username;
    private final String password;
    private final Date lastLogin;

    public UserDSRequest (String username, String password, Date lastLogin){
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }
}
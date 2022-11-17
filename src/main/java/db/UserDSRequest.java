package db;

import java.sql.Date;

public class UserDSRequest {
    private String username;
    private String password;
    private Date lastLogin;

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
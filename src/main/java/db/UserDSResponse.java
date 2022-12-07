package db;

import java.sql.Date;
import java.util.List;

/**
 * Response model class containing the information for creating a new user
 * object in the application from the entity database
 */
public record UserDSResponse(String username, String password, Date lastLogin, String compPort,
                             List<PortfolioDSResponse> portfolios) {


    /**
     * @return the username
     * Getter for the username
     */
    @Override
    public String username() {
        return this.username;
    }

    /**
     * @return the password
     * Getter for the password
     */
    @Override
    public String password() {
        return this.password;
    }

    /**
     * @return the lastLogin
     * Getter for the lastLogin
     */
    @Override
    public Date lastLogin() {
        return this.lastLogin;
    }

    /**
     * @return the compPort
     * Getter for the compPort
     */
    @Override
    public String compPort() {
        return compPort;
    }

    /**
     * @return the portfolios
     * Getter for the portfolios
     */
    @Override
    public List<PortfolioDSResponse> portfolios() {
        return this.portfolios;
    }
}
package db;

import java.sql.Date;
import java.util.List;

public class UserDSResponse {
    private final String username;
    private final String password;
    private final Date lastLogin;
    private final String compPort;
    private final List<PortfolioDSResponse> portfolios;

    public UserDSResponse(String username, String password, Date lastLogin, String compPort, List<PortfolioDSResponse> portfolios) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        this.compPort = compPort;
        this.portfolios = portfolios;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public String getCompPort() {
        return compPort;
    }

    public List<PortfolioDSResponse> getPortfolios() {
        return this.portfolios;
    }
}
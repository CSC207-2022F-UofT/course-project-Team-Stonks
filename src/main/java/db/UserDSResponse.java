package db;

import java.sql.Date;
import java.util.List;

public class UserDSResponse {
    String username;
    String password;
    Date lastLogin;
    List<PortfolioDSResponse> portfolios;

    public UserDSResponse(String username, String password, Date lastLogin, List<PortfolioDSResponse> portfolios) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
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

    public List<PortfolioDSResponse> getPortfolios() {
        return this.portfolios;
    }
}
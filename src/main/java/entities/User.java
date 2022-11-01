package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Portfolio> portfolios;
    private Date lastLogin;

    public User(String username, String password, Date lastLogin) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        portfolios = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addPortfolio(String name) {
        portfolios.add(PortfolioFactory.createPortfolio(name));
    }
}
package entities;

import db.iEntityDBGateway;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {
    private String username;
    private String password;
    private Map<String, Portfolio> nameToPortfolio;
    private Date lastLogin;
    private PortfolioFactory portfolioFactory = new PortfolioFactory();
    private iEntityDBGateway dbGateway;

    public User(String username, String password, Date lastLogin, iEntityDBGateway dbGateway) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        nameToPortfolio = new HashMap<>();
        this.dbGateway = dbGateway;
    }

    public User(String username, String password, Date lastLogin, Map<String, Portfolio> nameToPortfolio, iEntityDBGateway dbGateway) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        this.nameToPortfolio = nameToPortfolio;
        this.dbGateway = dbGateway;
    }

    public String getUsername() {
        return username;
    }

    public void addPortfolio(String name) {
        nameToPortfolio.put(name, portfolioFactory.createPortfolio(name, username, dbGateway));
    }

    public Portfolio getPortfolio(String portfolioName) {
        return nameToPortfolio.get(portfolioName);
    }

    public Set<String> getPortfolioNames() {
        return nameToPortfolio.keySet();
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public boolean isPassword(String password) {
        return this.password == password;
    }

    public void updatePortfolioStockValues(String portfolioName) {
        nameToPortfolio.get(portfolioName).updateStockValues(username);
    }

    public void updateLoginDate(Date loginDate) {
        dbGateway.updateUserLoginDate(username, loginDate);
    }
}
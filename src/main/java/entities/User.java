package entities;


import java.sql.Date;
import java.util.Map;
import java.util.Set;

public class User {
    private final String username;
    private final String password;
    private final Map<String, Portfolio> nameToPortfolio;
    private String curPortfolio;
    private final Date lastLogin;
    private final PortfolioFactory portfolioFactory = new PortfolioFactory();
    private String compPortfolio;

    public User(String username, String password, Date lastLogin, String compPortfolio, Map<String, Portfolio> nameToPortfolio) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        this.nameToPortfolio = nameToPortfolio;

        if (!compPortfolio.equals("null")) {
            this.compPortfolio = compPortfolio;
        }
    }

    public String getUsername() {
        return username;
    }

    public void addPortfolio(String name) {
        if (nameToPortfolio.isEmpty()) {
            compPortfolio = name;
        }
        nameToPortfolio.put(name, portfolioFactory.createPortfolio(name, username));

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
        return this.password.equals(password);
    }

    public Portfolio getCurPortfolio() {
        return nameToPortfolio.get(curPortfolio);
    }

    public Portfolio getCompPortfolio() {
        return nameToPortfolio.get(compPortfolio);
    }

    public String getCompPortfolioName() {
        return compPortfolio;
    }

    public void setCurPortfolio(String curPortfolio) {
        this.curPortfolio = curPortfolio;
    }

    public void setCompPortfolio(String compPortfolio) {
        this.compPortfolio = compPortfolio;
    }
}
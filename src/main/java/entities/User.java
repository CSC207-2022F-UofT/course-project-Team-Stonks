package entities;


import java.sql.Date;
import java.util.Map;
import java.util.Set;

public class User {
    /**
     * Construct a User with the given username, password, portfolio and last login date
     */
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


    /**
     * @return the username of this object
     */
    public String getUsername() {
        return username;
    }


    /**
     * @param name non-empty string representing a new portfolio's name
     * adds new portfolio
     */
    public void addPortfolio(String name) {
        if (nameToPortfolio.isEmpty()) {
            compPortfolio = name;
        }
        nameToPortfolio.put(name, portfolioFactory.createPortfolio(name, username));

    }


    /**
     * @param portfolioName non-empty string representing a new portfolio's name
     * @return portfolio with given name
     */
    public Portfolio getPortfolio(String portfolioName) {
        return nameToPortfolio.get(portfolioName);
    }

    /**
     * @return all portfolio names user owns
     */
    public Set<String> getPortfolioNames() {
        return nameToPortfolio.keySet();
    }

    /**
     * @return user's last login date
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param password non-empty string
     * @return if input is equal to user's password
     */
    public boolean isPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * @return user's current portfolio
     */
    public Portfolio getCurPortfolio() {
        return nameToPortfolio.get(curPortfolio);
    }

    /**
     * @return user's competitive portfolio
     */
    public Portfolio getCompPortfolio() {
        return nameToPortfolio.get(compPortfolio);
    }

    /**
     * @return user's competitive portfolio's name
     */
    public String getCompPortfolioName() {
        return compPortfolio;
    }


    /**
     * @param curPortfolio non-empty string
     * sets user's current portfolio to the input
     */
    public void setCurPortfolio(String curPortfolio) {
        this.curPortfolio = curPortfolio;
    }

    /**
     * @param compPortfolio non-empty string
     * sets user's competitive portfolio to the input
     */
    public void setCompPortfolio(String compPortfolio) {
        this.compPortfolio = compPortfolio;
    }
}
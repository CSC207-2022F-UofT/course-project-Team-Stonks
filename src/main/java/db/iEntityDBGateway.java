package db;

import java.sql.Date;
import java.util.List;

public interface iEntityDBGateway {
    void addCompPort(String username, String compPort);

    void deleteUser(String username);

    List<UserDSResponse> getAllUsers();

    /**
     * Adds user to database
     */
    void addUser(UserDSRequest newUser);

    /**
     * <pre>
     * Searches for user in database based on given username
     *
     * Returns User object if it is found, null otherwise
     * </pre>
     */
    boolean findUser(String username);

    UserDSResponse findUserPortfolios(String username, String password);

    void updateUserLoginDate(String username, Date loginDate);

    /**
     * Adds portfolio to given user in the database
     */
    void addPortfolio(PortfolioDSRequest newPortfolio);

    /**
     * <pre>
     * Searches for portfolio in database based on given username and portfolioName
     *
     * Returns User object if it is found, null otherwise
     * </pre>
     */
    PortfolioDSResponse findPortfolio(String portfolioName, String username);

    /**
     * Deletes portfolio from the database based on name, if it exists
     */
    void deletePortfolio(String name, String username);

    void updatePortfolioBalance(String name, double newBalance, String username);

    /**
     * Adds stock to database
     */
    void addStock(StockDSRequest newStock);

    StockDSResponse findStock(String symbol, String username, String portfolioName);

    boolean findStock(String symbol);

    /**
     * Deletes stock from the database based on id, if it exists
     */
    void deleteStock(String symbol, String username, String portfolioName);

    void updateStockValue(String symbol, double newValue);

    void updateStockQuantity(String symbol, int newQuantity, String username, String portfolioName);

}
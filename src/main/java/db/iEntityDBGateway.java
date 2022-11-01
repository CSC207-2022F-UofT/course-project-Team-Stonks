package db;

import entities.Portfolio;
import entities.Stock;
import entities.User;

public interface iEntityDBGateway {
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
    User findUser(String username);


    /**
     * Deletes user from the database based on username, if it exists
     */
    void deleteUser(String username);


    /**
     * Adds user to database
     */
    void addPortfolio(PortfolioDSRequest newPortfolio);

    /**
     * <pre>
     * Searches for user in database based on given username
     *
     * Returns User object if it is found, null otherwise
     * </pre>
     */
    Portfolio findPortfolio(String username);


    /**
     * Deletes portfolio from the database based on name, if it exists
     */
    void deletePortfolio(String name);

    /**
     * Adds stock to database
     */
    void addStock(StockDSRequest newStock);

    /**
     * <pre>
     * Searches for stock in database based on given id
     *
     * Returns Stock object if it is found, null otherwise
     * </pre>
     */
    Stock findStock(int id);

    /**
     * Deletes stock from the database based on id, if it exists
     */
    void deleteStock(int id);
}
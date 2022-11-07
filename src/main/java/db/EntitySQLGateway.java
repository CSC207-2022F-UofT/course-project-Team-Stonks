package db;

import java.sql.*;

public class EntitySQLGateway implements iEntityDBGateway {
    Connection connection;

    public EntitySQLGateway() {
        String connectionUrl =
                "jdbc:sqlserver://142.188.14.250:1433;"
                        + "database=entities;"
                        + "user=teammate;"
                        + "password=CSC207Stocks;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param newUser
     */
    @Override
    public void addUser(UserDSRequest newUser) {
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users VALUES (" +
                            newUser.username() + "," +
                            newUser.password() + "," +
                            newUser.lastLogin());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean findUser(String username) {
        return false;
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserDSResponse findUser(String username, String password) {
        return null;
    }

    /**
     * @param username
     */
    @Override
    public void deleteUser(String username) {

    }

    /**
     * @param newPortfolio
     */
    @Override
    public void addPortfolio(PortfolioDSRequest newPortfolio) {

    }

    /**
     * @param portfolioName
     * @param username
     * @return
     */
    @Override
    public PortfolioDSResponse findPortfolio(String portfolioName, String username) {
        return null;
    }

    /**
     * @param name
     * @param username
     */
    @Override
    public void deletePortfolio(String name, String username) {

    }

    /**
     * @param newStock
     */
    @Override
    public void addStock(StockDSRequest newStock) {

    }

    /**
     * @param stock
     * @return
     */
    @Override
    public StockDSResponse findStock(StockDSResponse stock) {
        return null;
    }

    /**
     * @param symbol
     * @param username
     * @param portfolioName
     */
    @Override
    public void deleteStock(String symbol, String username, String portfolioName) {

    }

    /**
     * @param symbol
     * @param newValue
     * @param username
     * @param portfolioName
     */
    @Override
    public void updateStockValue(String symbol, String newValue, String username, String portfolioName) {

    }

    /**
     * @param symbol
     * @param newQuantity
     * @param username
     * @param portfolioName
     */
    @Override
    public void updateStockQuantity(String symbol, int newQuantity, String username, String portfolioName) {

    }
}
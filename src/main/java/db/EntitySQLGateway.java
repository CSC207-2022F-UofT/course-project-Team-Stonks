package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntitySQLGateway implements iEntityDBGateway {
    Connection con;

    public EntitySQLGateway() {
        String connectionUrl =
                "jdbc:sqlserver://MSI\\SQLEXPRESS;"
                        + "database=entities;"
                        + "user=teammate;"
                        + "password=CSC207Stocks;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try {
            con = DriverManager.getConnection(connectionUrl);
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
            PreparedStatement st = con.prepareStatement(
                    "INSERT INTO Users VALUES (" +
                            newUser.username() + "," +
                            newUser.password() + "," +
                            newUser.lastLogin());
            st.executeQuery();
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
        try{
            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Users WHERE username = ?");
            st.setString(1, username);

            return st.executeQuery().isBeforeFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDSResponse findUser(String username, String password) {
        try{
            List<PortfolioDSResponse> portfolioDSResponses = new ArrayList<>();

            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Users WHERE " +
                            "username = ? AND " +
                            "password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet userRS = st.executeQuery();
            userRS.next();

            st = con.prepareStatement(
                    "SELECT * FROM Portfolios WHERE username = ?");
            st.setString(1, username);
            ResultSet portfolioRS = st.executeQuery();

            while (portfolioRS.next()) {
                portfolioDSResponses.add(findPortfolio(
                     portfolioRS.getString(1),
                     portfolioRS.getString(3)
                ));
            }

            return new UserDSResponse(userRS.getString(1),
                    userRS.getString(2),
                    userRS.getDate(3),
                    portfolioDSResponses);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param username
     */
    @Override
    public void deleteUser(String username) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "DELETE User WHERE username = ?");
            st.setString(1, username);
            st.executeQuery();

            st = con.prepareStatement(
                    "SELECT name FROM Portfolios WHERE username = ?");
            st.setString(1, username);
            ResultSet portfolioRS = st.executeQuery();

            while (portfolioRS.next()) {
                deletePortfolio(
                        portfolioRS.getString(1),
                        username);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param newPortfolio
     */
    @Override
    public void addPortfolio(PortfolioDSRequest newPortfolio) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "INSERT INTO Portfolios VALUES (" +
                            newPortfolio.name() + "," +
                            newPortfolio.balance() + "," +
                            newPortfolio.username());
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param portfolioName
     * @param username
     * @return
     */
    @Override
    public PortfolioDSResponse findPortfolio(String portfolioName, String username) {
        try{
            List<StockDSResponse> stockDSResponses = new ArrayList<>();

            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Portfolio WHERE " +
                            "name = ? AND" +
                            "username = ?");
            st.setString(1, portfolioName);
            st.setString(2, username);
            ResultSet portfolioRS = st.executeQuery();
            portfolioRS.next();

            st = con.prepareStatement("SELECT stockName FROM PortfolioStock WHERE" +
                    "portfolioName = ? AND" +
                    "username = ?");
            st.setString(1, portfolioName);
            st.setString(2, username);
            ResultSet portfolioStockRS = st.executeQuery();

            while (portfolioStockRS.next()) {
                stockDSResponses.add(findStock(
                        portfolioStockRS.getString(1),
                        username,
                        portfolioName));
            }

            return new PortfolioDSResponse(
                    portfolioRS.getString(1),
                    portfolioRS.getDouble(2),
                    stockDSResponses);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param name
     * @param username
     */
    @Override
    public void deletePortfolio(String name, String username) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "DELETE Portfolio WHERE" +
                            "name = ? AND" +
                            "username = ?");
            st.setString(1, name);
            st.setString(2, username);
            st.executeQuery();

            st = con.prepareStatement("SELECT stockName FROM PortfolioStock WHERE" +
                    "portfolioName = ? AND" +
                    "username = ?");
            st.setString(1, name);
            st.setString(2, username);
            ResultSet stockRS = st.executeQuery();

            while (stockRS.next()) {
                deleteStock(
                        stockRS.getString(1),
                        username,
                        name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param newStock
     */
    @Override
    public void addStock(StockDSRequest newStock) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "INSERT INTO Stocks VALUES (" +
                            newStock.symbol() + "," +
                            newStock.value());
            st.executeQuery();
            st = con.prepareStatement(
                    "INSERT INTO PortfolioStock VALUES (" +
                            newStock.portfolioName() + "," +
                            newStock.symbol() + "," +
                            newStock.quantity() + "," +
                            newStock.username());
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StockDSResponse findStock(String symbol, String username, String portfolioName) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Stocks WHERE symbol = ?");
            st.setString(1, symbol);
            ResultSet stockRS = st.executeQuery();
            stockRS.next();

            st = con.prepareStatement(
                    "SELECT quantity FROM PortfolioStock WHERE " +
                            "portfolioName = ? AND " +
                            "stockName = ? AND " +
                            "username = ?");
            st.setString(1, portfolioName);
            st.setString(2, symbol);
            st.setString(3, username);
            ResultSet portfolioStockRS = st.executeQuery();
            portfolioStockRS.next();

            return new StockDSResponse(
                    stockRS.getString(1),
                    stockRS.getDouble(2),
                    portfolioStockRS.getInt(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStock(String symbol, String username, String portfolioName) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "DELETE PortfolioStock WHERE" +
                            "portfolioName = ? AND" +
                            "stockName = ? AND" +
                            "username = ?");
            st.setString(1, portfolioName);
            st.setString(2, symbol);
            st.setString(3, username);
            st.executeQuery();

            st = con.prepareStatement("SELECT * FROM PortfolioStock WHERE" +
                    "stockName = ?");
            st.setString(1, symbol);

            if (!st.executeQuery().isBeforeFirst()) {
                st = con.prepareStatement("DELETE Stocks WHERE" +
                        "symbol = ?");
                st.setString(1, symbol);
                st.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStockValue(String symbol, double newValue) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "UPDATE Stocks SET " +
                            "value = ? WHERE" +
                            "symbol = ?");
            st.setDouble(1, newValue);
            st.setString(2, symbol);
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param symbol
     * @param newQuantity
     * @param username
     * @param portfolioName
     */
    @Override
    public void updateStockQuantity(String symbol, int newQuantity, String username, String portfolioName) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "UPDATE PortfolioStock SET " +
                            "quantity = ? WHERE" +
                            "portfolioName = ? AND " +
                            "stockName = ? AND " +
                            "username = ?");
            st.setInt(1, newQuantity);
            st.setString(2, portfolioName);
            st.setString(3, symbol);
            st.setString(4, username);
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntitySQLGateway implements iEntityDBGateway {
    Connection con;

    public EntitySQLGateway() {
        String dbURL = "db-mysql-nyc1-71885-do-user-10038162-0.b.db.ondigitalocean.com" +
                ";database=defaultdb;encrypt=true;trustServerCertificate=true;loginTimeout=10;";
        String user = "doadmin";
        String pass = "AVNS_3ACCOAF3QXEZedJQXcx";
        try {
            con = DriverManager.getConnection(dbURL, user, pass);
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
            Statement st = con.createStatement();
            st.executeQuery("INSERT INTO Users VALUES ('" +
                    newUser.getUsername() + "','" +
                    newUser.getPassword() + "','" +
                    newUser.getLastLogin() + "')");
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

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserDSResponse findUserPortfolios(String username, String password) {
        try{
            List<PortfolioDSResponse> portfolioDSResponses = new ArrayList<>();

            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Users WHERE " +
                            "username = ? AND " +
                            "password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet userRS = st.executeQuery();
            boolean userFound = userRS.next();

            st = con.prepareStatement(
                    "SELECT name, balance FROM Portfolios WHERE username = ?");
            st.setString(1, username);
            ResultSet portfolioRS = st.executeQuery();

            while (portfolioRS.next()) {
                portfolioDSResponses.add(new PortfolioDSResponse(
                        portfolioRS.getString(1),
                        portfolioRS.getDouble(2),
                        new ArrayList<>()
                ));
            }
            if (userFound) {
                return new UserDSResponse(userRS.getString(1),
                        userRS.getString(2),
                        userRS.getDate(3),
                        portfolioDSResponses);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param username
     */
    @Override
    public void updateUserLoginDate(String username, Date loginDate) {
        try{
            Statement st = con.createStatement();
            st.execute(
                    "UPDATE Users SET " +
                            "lastLogin = '" + loginDate + "' WHERE " +
                            "username = '" + username + "'");
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
            Statement st = con.createStatement();
            st.executeQuery("INSERT INTO Portfolios VALUES ('" +
                    newPortfolio.getName() + "','" +
                    newPortfolio.getBalance() + "','" +
                    newPortfolio.getUsername() + "')");
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
                    "SELECT * FROM Portfolios WHERE " +
                            "name = ? AND " +
                            "username = ?");
            st.setString(1, portfolioName);
            st.setString(2, username);
            ResultSet portfolioRS = st.executeQuery();
            boolean portfolioFound = portfolioRS.next();

            st = con.prepareStatement("SELECT stockName FROM PortfolioStock WHERE " +
                    "portfolioName = ? AND " +
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

            if (portfolioFound) {
                return new PortfolioDSResponse(
                        portfolioRS.getString(1),
                        portfolioRS.getDouble(2),
                        stockDSResponses);
            }

            return null;

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
            PreparedStatement ps = con.prepareStatement("SELECT stockName FROM PortfolioStock WHERE " +
                    "portfolioName = ? AND " +
                    "username = ?");
            ps.setString(1, name);
            ps.setString(2, username);
            ResultSet stockRS = ps.executeQuery();

            while (stockRS.next()) {
                deleteStock(
                        stockRS.getString(1),
                        username,
                        name);
            }

            Statement st = con.createStatement();
            st.execute(
                    "DELETE Portfolios WHERE " +
                            "name = '" + name + "' AND " +
                            "username = '" + username + "'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePortfolioBalance(String name, double newBalance, String username) {
        try{
            Statement st = con.createStatement();
            st.execute(
                    "UPDATE Portfolios SET " +
                            "balance = '" + newBalance + "' WHERE " +
                            "name = '" + name + "' AND " +
                            "username = '" + username + "'");
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
            Statement st;

            if (!findStock(newStock.getSymbol())){
                st = con.createStatement();
                st.execute(
                        "INSERT INTO Stocks VALUES ('" +
                                newStock.getSymbol() + "','" +
                                newStock.getValue() + "')");
            }

            st = con.createStatement();
            st.execute(
                    "INSERT INTO PortfolioStock VALUES ('" +
                            newStock.getPortfolioName() + "','" +
                            newStock.getSymbol() + "','" +
                            newStock.getQuantity() + "','" +
                            newStock.getUsername() + "')");
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

            if (portfolioStockRS.next()) {
                return new StockDSResponse(
                        stockRS.getString(1),
                        stockRS.getDouble(2),
                        portfolioStockRS.getInt(1));
            }

            return null;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findStock(String symbol) {
        try{
            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Stocks WHERE symbol = ?");
            st.setString(1, symbol);

            return st.executeQuery().isBeforeFirst();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStock(String symbol, String username, String portfolioName) {
        try{
            Statement st = con.createStatement();
            st.execute(
                    "DELETE PortfolioStock WHERE " +
                            "portfolioName = '" + portfolioName + "' AND " +
                            "stockName = '" + symbol + "' AND " +
                            "username = '" + username + "'");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM PortfolioStock WHERE " +
                    "stockName = ?");
            ps.setString(1, symbol);

            if (!ps.executeQuery().isBeforeFirst()) {
                st = con.createStatement();
                st.execute("DELETE Stocks WHERE " +
                        "symbol = '" + symbol + "'");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStockValue(String symbol, double newValue) {
        try{
            Statement st = con.createStatement();
            st.execute(
                    "UPDATE Stocks SET " +
                            "value = '" + newValue + "' WHERE" +
                            "symbol = '" + symbol + "'");
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
            Statement st = con.createStatement();
            st.execute(
                    "UPDATE PortfolioStock SET " +
                            "quantity = '" + newQuantity + "' WHERE " +
                            "portfolioName = '" + portfolioName + "' AND " +
                            "stockName = '" + symbol + "' AND " +
                            "username = '" + username + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
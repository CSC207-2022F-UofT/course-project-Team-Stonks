package db;

/**
 * Request model class containing input for creating a new stock
 * object in the entity database
 */
public class StockDSRequest {
    private final String symbol;
    private final double value;
    private final int quantity;
    private final String username;
    private final String portfolioName;

    public StockDSRequest(String symbol, double value, int quantity, String username, String portfolioName){
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
        this.username = username;
        this.portfolioName = portfolioName;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPortfolioName() {
        return this.portfolioName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getValue() {
        return this.value;
    }
}
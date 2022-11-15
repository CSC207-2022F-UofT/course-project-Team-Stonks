package db;

public class StockDSRequest {
    String symbol;
    double value;
    int quantity;
    String username;
    String portfolioName;

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
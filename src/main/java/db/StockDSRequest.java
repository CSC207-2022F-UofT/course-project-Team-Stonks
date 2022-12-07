package db;

/**
 * Request model class containing input for creating a new stock
 * object in the entity database
 */
public record StockDSRequest(String symbol, double value, int quantity, String username, String portfolioName) {

    /**
     * @return String symbol of the stock
     * Getter for the symbol of the stock
     */
    @Override
    public String symbol() {
        return this.symbol;
    }

    /**
     * @return double value of the stock
     * Getter for the value of the stock
     */
    @Override
    public String username() {
        return this.username;
    }

    /**
     * @return int quantity of the stock
     * Getter for the quantity of the stock
     */
    @Override
    public String portfolioName() {
        return this.portfolioName;
    }

    /**
     * @return String username of the stock
     * Getter for the username of the stock
     */
    @Override
    public int quantity() {
        return this.quantity;
    }

    /**
     * @return String portfolioName of the stock
     * Getter for the portfolioName of the stock
     */
    @Override
    public double value() {
        return this.value;
    }
}
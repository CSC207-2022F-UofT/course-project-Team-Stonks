package db;

/**
 * Response model class containing the information for creating a new stock
 * object in the application from the entity database
 */
public record StockDSResponse(String symbol, double value, int quantity) {

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
    public double value() {
        return this.value;
    }

    /**
     * @return int quantity of the stock
     * Getter for the quantity of the stock
     */
    @Override
    public int quantity() {
        return this.quantity;
    }
}
package db;

/**
 * Response model class containing the information for creating a new stock
 * object in the application from the entity database
 */
public class StockDSResponse {
    private final String symbol;
    private final double value;
    private final int quantity;

    public StockDSResponse (String symbol, double value, int quantity){
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getValue() {
        return this.value;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
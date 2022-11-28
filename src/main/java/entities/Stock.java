package entities;

public class Stock {
    /**
     * Construct a Stock with the given symbol, value and quantity
     */
    private final String symbol;
    private final double value;
    private int quantity;

    public Stock(String symbol, double value, int quantity) {
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public void addQuantity(int quantity, String username, String portfolioName) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
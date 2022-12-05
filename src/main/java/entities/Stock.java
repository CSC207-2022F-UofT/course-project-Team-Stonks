package entities;

public class Stock {
    /**
     * Construct a Stock with the given symbol, value and quantity
     */
    private final String symbol;
    private double value;
    private int quantity;

    public Stock(String symbol, double value, int quantity) {
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
    }


    /**
     * @return gets stock's name
     */
    public String getSymbol(){
        return symbol;
    }

    /**
     * @return gets stock's value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param quantity new quantity of stock to be added
     * adds quanitity amount of the stock
     */
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * @return gets stock's quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * @param value positive value of stock
     * sets new value to be the stock's value
     */
    public void setValue(double value) {
        this.value = value;
    }
}
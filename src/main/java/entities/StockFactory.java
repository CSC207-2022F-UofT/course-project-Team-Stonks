package entities;


public class StockFactory {
    /**
     * This class is responsible for creating a Stock object
     */

    public Stock createStock(String symbol, double value, int quantity) {
        return new Stock(symbol, value, quantity);
    }
}
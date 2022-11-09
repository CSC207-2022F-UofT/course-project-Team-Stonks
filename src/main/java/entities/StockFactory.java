package entities;

public class StockFactory {
    public Stock createStock(String symbol, double value, int quantity) {
        return new Stock(symbol, value, quantity);
    }
}
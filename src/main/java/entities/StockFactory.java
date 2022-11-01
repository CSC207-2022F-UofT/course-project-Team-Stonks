package entities;

public class StockFactory {
    public static Stock createStock(String symbol, double value) {
        return new Stock(symbol, value);
    }
}
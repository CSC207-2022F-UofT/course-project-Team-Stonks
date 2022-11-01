package entities;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double balance;
    private String name;
    private Map<Stock, Integer> stockToQuantity;

    public Portfolio(String name) {
        balance = 0;
        this.name = name;
        stockToQuantity = new HashMap<>();
    }

    public Portfolio(double balance, String name, Map<Stock, Integer> stockToQuantity) {
        this.balance = balance;
        this.name = name;
        this.stockToQuantity = stockToQuantity;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Map<Stock, Integer> getStockToQuantity() {
        return stockToQuantity;
    }

    public void addAmount(double amount) {
        balance += amount;
    }

    public void addStock(String symbol, int value, int quantity) {
        for (Stock stock : stockToQuantity.keySet()) {
            if (stock.getSymbol() == symbol) {
                stockToQuantity.put(stock, stockToQuantity.get(stock) + quantity);
                return;
            }
        }

        stockToQuantity.put(StockFactory.createStock(symbol, value), quantity);
    }
}
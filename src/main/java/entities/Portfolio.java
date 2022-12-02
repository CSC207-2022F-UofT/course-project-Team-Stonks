package entities;

import BuyStockUseCase.BuyType;
import SellStockUseCase.SellType;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    /**
     * Construct a Portfolio with the given name, balance and stocks
     */
    private double balance;
    private final String name;
    private final String username;
    private final Map<String, Stock> symbolToStock;
    private final StockFactory stockFactory = new StockFactory();

    public Portfolio(double balance, String name, String username) {
        this.balance = balance;
        this.name = name;
        symbolToStock = new HashMap<>();
        this.username = username;
    }

    public Portfolio(double balance, String name, Map<String, Stock> symbolToStock, String username) {
        this.balance = balance;
        this.name = name;
        this.symbolToStock = symbolToStock;
        this.username = username;
    }

    public double getBalance() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return Double.parseDouble(numberFormat.format(balance));
    }

    public String getName() {
        return name;
    }

    public Map<String, Stock> getSymbolToStock() {
        return symbolToStock;
    }

    public String getUsername() {
        return username;
    }

    public int getStockQuantity(String symbol) {
        Stock stock = symbolToStock.get(symbol);

        if (stock != null) {
            return symbolToStock.get(symbol).getQuantity();
        }

        return 0;
    }


    /**
     * <p>
     * adds *quantity* amount of the stock to user's portfolio if user has sufficent funds and returns true,
     * otherwise does nothing and return false
     * </p>
     *
     * @param symbol   represents a stock's name
     * @param value    non-negative number
     * @param quantity positive integer
     */
    public BuyType addStock(String symbol, double value, int quantity) {
        Stock stock = symbolToStock.get(symbol);

        if (balance < value * quantity) {
            return BuyType.FAILED;
        }

        balance -= value * quantity;

        if (stock != null) {
            stock.addQuantity(quantity);
            stock.setValue(value);
            return BuyType.EXISTING;
        }

        symbolToStock.put(symbol, stockFactory.createStock(symbol, value, quantity));
        return BuyType.NEW;
    }

    /**
     * <p>
     * returns true and sells the quantity of stock with given symbol if user
     * has sufficient stock quantity, otherwise does nothing and return false
     * </p>
     *
     * @param symbol   non-empty string
     * @param quantity positive int
     */
    public SellType sellStock(String symbol, double value, int quantity) {
        Stock stock = symbolToStock.get(symbol);

        if (stock.getQuantity() < quantity) {
            return SellType.ERROR;
        }

        balance += quantity * value;
        stock.setValue(value);

        if (quantity == stock.getQuantity()) {
            symbolToStock.remove(symbol);
            return SellType.REMOVE;
        }

        stock.addQuantity(-quantity);

        return SellType.SUCCESFUL;
    }

    public void pullStocks(List<Stock> newStocks) {
        for (Stock stock : newStocks) {
            symbolToStock.put(stock.getSymbol(), stock);
        }
    }

    public double getNetValue() {
        double total = 0;
        for (Stock stock : symbolToStock.values()) {
            total += stock.getValue() * stock.getQuantity();
        }
        total += balance;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return Double.parseDouble(numberFormat.format(total));
    }
}
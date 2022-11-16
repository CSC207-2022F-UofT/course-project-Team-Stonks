package entities;

import db.StockDSResponse;
import db.iEntityDBGateway;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double balance;
    private String name;
    private Map<String, Stock> symbolToStock;
    private StockFactory stockFactory = new StockFactory();
    private iEntityDBGateway dbGateWay;

    public Portfolio(String name, iEntityDBGateway dbGateway) {
        balance = 0;
        this.name = name;
        symbolToStock = new HashMap<>();
        this.dbGateWay = dbGateway;
    }

    public Portfolio(double balance, String name, Map<String, Stock> symbolToStock, iEntityDBGateway dbGateway) {
        this.balance = balance;
        this.name = name;
        this.symbolToStock = symbolToStock;
        this.dbGateWay = dbGateway;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Map<String, Stock> getSymbolToStock() {
        return symbolToStock;
    }


    public int getStockQuantity(String symbol) {
        return symbolToStock.get(symbol).getQuantity();
    }


    /**
     * <p>
     *     adds *quantity* amount of the stock to user's portfolio if user has sufficent funds and returns true,
     *     otherwise does nothing and return false
     * </p>
     * @param symbol represents a stock's name
     * @param value non-negative number
     * @param quantity positive integer
     */
    public boolean addStock(String symbol, double value, int quantity) {
        Stock stock = symbolToStock.get(symbol);

        if (balance < value * quantity) {
            return false;
        }

        if (stock != null) {
            stock.addQuantity(quantity);
        } else {
            symbolToStock.put(symbol, stockFactory.createStock(symbol, value, quantity));
        }

        balance -= value * quantity;

        return true;
    }

    /**
     * <p>
     *     returns true and sells the quantity of stock with given symbol if user
     *     has sufficient stock quantity, otherwise does nothing and return false
     * </p>
     * @param symbol non-empty string
     * @param quantity positive int
     */
    public boolean sellStock(String symbol, int quantity) {
        Stock stock = symbolToStock.get(symbol);

        if (stock.getQuantity() < quantity) {
            return false;
        }

        balance += quantity * stock.getValue();

        if (quantity == stock.getQuantity()) {
            symbolToStock.remove(symbol);
        } else {
            stock.addQuantity(-quantity);
        }

        return true;
    }

    public void updateStockValues(String username) {
        for (Stock stock : symbolToStock.values()) {
            Stock dsStock = convertStockDSResponse(
                    dbGateWay.findStock(stock.getSymbol(), username, name));
            stock.setValue(dsStock.getValue());
        }
    }

    public Stock convertStockDSResponse(StockDSResponse dsResponse) {
        return stockFactory.createStock(dsResponse.symbol(), dsResponse.value(), dsResponse.quantity());
    }
}
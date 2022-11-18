package entities;

import db.StockDSResponse;
import db.iEntityDBGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private double balance;
    private final String name;
    private final Map<String, Stock> symbolToStock;
    private final StockFactory stockFactory = new StockFactory();
    private final iEntityDBGateway dbGateWay;

    public Portfolio(double balance, String name, iEntityDBGateway dbGateway) {
        this.balance = balance;
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


    /**
     * <p>
     *     adds *quantity* amount of the stock to user's portfolio if user has sufficent funds and returns true,
     *     otherwise does nothing and return false
     * </p>
     * @param symbol represents a stock's name
     * @param value non-negative number
     * @param quantity positive integer
     */
    public boolean addStock(String symbol, double value, int quantity, String username) {
        Stock stock = symbolToStock.get(symbol);

        if (balance < value * quantity) {
            return false;
        }

        if (stock != null) {
            stock.addQuantity(quantity, username, name);
        } else {
            symbolToStock.put(symbol, stockFactory.createStock(symbol, value, quantity, username, name, dbGateWay));
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
    public boolean sellStock(String symbol, int quantity, String username) {
        Stock stock = symbolToStock.get(symbol);

        if (stock.getQuantity() < quantity) {
            return false;
        }

        balance += quantity * stock.getValue();
        dbGateWay.updatePortfolioBalance(name, balance, username);

        if (quantity == stock.getQuantity()) {
            symbolToStock.remove(symbol);
            dbGateWay.deleteStock(symbol, username, name);
        } else {
            stock.addQuantity(-quantity, username, name);
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

    public void pullStocks(List<Stock> newStocks) {
        for (Stock stock : newStocks) {
            symbolToStock.put(stock.getSymbol(), stock);
        }
    }

    public Stock convertStockDSResponse(StockDSResponse dsResponse) {
        return stockFactory.createStock(dsResponse.getSymbol(), dsResponse.getValue(), dsResponse.getQuantity(), dbGateWay);
    }
}
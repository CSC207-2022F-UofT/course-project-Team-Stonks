package entities;

import db.StockDSRequest;
import db.iEntityDBGateway;

public class StockFactory {
    public Stock createStock(String symbol, double value, int quantity, String username, String portfolioName, iEntityDBGateway dbGateway) {
        dbGateway.addStock(new StockDSRequest(symbol, value, quantity, username, portfolioName));
        return new Stock(symbol, value, quantity, dbGateway);
    }

    public Stock createStock(String symbol, double value, int quantity, iEntityDBGateway dbGateway) {
        return new Stock(symbol, value, quantity, dbGateway);
    }
}
package entities;

import db.iEntityDBGateway;

public class Stock {
    private String symbol;
    private double value;
    private int quantity;
    private iEntityDBGateway dbGateway;

    public Stock(String symbol, double value, int quantity, iEntityDBGateway dbGateway) {
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
        this.dbGateway = dbGateway;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public void addQuantity(int quantity, String username, String portfolioName) {
        this.quantity += quantity;
        dbGateway.updateStockQuantity(symbol, this.quantity, username, portfolioName);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setValue(double value) {
        this.value = value;
        dbGateway.updateStockValue(symbol, value);
    }
}
package db;

import java.util.List;

public class PortfolioDSResponse {
    private String name;
    private double balance;
    private List<StockDSResponse> stocks;

    public PortfolioDSResponse(String name, double balance, List<StockDSResponse> stocks){
        this.name = name;
        this.balance = balance;
        this.stocks = stocks;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<StockDSResponse> getStocks() {
        return this.stocks;
    }
}
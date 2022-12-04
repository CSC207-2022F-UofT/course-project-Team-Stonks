package db;

import java.util.List;

/**
 * Response model class containing the information for creating a new portfolio
 * object in the application from the entity database
 */
public class PortfolioDSResponse {
    private final String name;
    private final double balance;
    private final List<StockDSResponse> stocks;

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
package entities;

import db.PortfolioDSRequest;
import db.StockDSResponse;
import db.iEntityDBGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioFactory {
    /**
     * This class is responsible for creating a Portfolio object
     */
    private final StockFactory stockFactory = new StockFactory();
    private final double BALANCE = 10000;

    public Portfolio createPortfolio(String name, String username, iEntityDBGateway dbGateway) {
        dbGateway.addPortfolio(new PortfolioDSRequest(name, BALANCE, username));
        return new Portfolio(BALANCE, name, dbGateway, username);
    }

    public Portfolio createPortfolio(double balance, String name, String username, List<StockDSResponse> stocks, iEntityDBGateway dbGateway) {
        Map<String, Stock> symbolToStock = new HashMap<>();

        for (StockDSResponse stock : stocks) {
            Stock newStock = stockFactory.createStock(stock.getSymbol(), stock.getValue(), stock.getQuantity(), dbGateway);
            symbolToStock.put(stock.getSymbol(), newStock);
        }

        return new Portfolio(balance, name, symbolToStock, dbGateway, username);
    }
}
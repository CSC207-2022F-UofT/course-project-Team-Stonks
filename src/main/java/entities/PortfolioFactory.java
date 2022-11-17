package entities;

import db.StockDSResponse;
import db.iEntityDBGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioFactory {
    private StockFactory stockFactory = new StockFactory();

    public Portfolio createPortfolio(String name, iEntityDBGateway dbGateway) {
        return new Portfolio(name, dbGateway);
    }

    public Portfolio createPortfolio(double balance, String name, List<StockDSResponse> stocks, iEntityDBGateway dbGateway) {
        Map<String, Stock> symbolToStock = new HashMap<>();

        for (StockDSResponse stock : stocks) {
            Stock newStock = stockFactory.createStock(stock.getSymbol(), stock.getValue(), stock.getQuantity());
            symbolToStock.put(stock.getSymbol(), newStock);
        }

        return new Portfolio(balance, name, symbolToStock, dbGateway);
    }
}
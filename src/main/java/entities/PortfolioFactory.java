package entities;

import db.StockDSResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioFactory {

    public static Portfolio createPortfolio(String name) {
        return new Portfolio(name);
    }

    public static Portfolio createPortfolio(double balance, String name, List<StockDSResponse> stocks) {
        Map<Stock, Integer> stockToQuantity = new HashMap<>();

        for (StockDSResponse stock : stocks) {
            Stock newStock = StockFactory.createStock(stock.symbol(), stock.value());
            stockToQuantity.put(newStock, stock.quantity());
        }

        return new Portfolio(balance, name, stockToQuantity);
    }
}
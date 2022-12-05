package entities;

import db.StockDSResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioFactory {
    /**
     * This class is responsible for creating a Portfolio object
     */
    private final StockFactory stockFactory = new StockFactory();
    public static final double BALANCE = 10000;


    /**
     * @param name non-empty string reprensting a portfolio's name
     * @param username non-empty string reprensting a user's name
     * @return new portfolio object based on given input
     */
    public Portfolio createPortfolio(String name, String username) {
        return new Portfolio(BALANCE, name, username);
    }

    /**
     * @param balance positive double representing portfolio's balance
     * @param name non-empty string reprensting a portfolio's name
     * @param username non-empty string reprensting a user's name
     * @param stocks list of stocks from the database
     * @return new portfolio object based on given input
     */
    public Portfolio createPortfolio(double balance, String name, String username, List<StockDSResponse> stocks) {
        Map<String, Stock> symbolToStock = new HashMap<>();

        for (StockDSResponse stock : stocks) {
            Stock newStock = stockFactory.createStock(stock.getSymbol(), stock.getValue(), stock.getQuantity());
            symbolToStock.put(stock.getSymbol(), newStock);
        }

        return new Portfolio(balance, name, symbolToStock, username);
    }
}
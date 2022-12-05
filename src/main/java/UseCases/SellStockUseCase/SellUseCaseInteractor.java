package UseCases.SellStockUseCase;

import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import db.iEntityDBGateway;
import entities.Portfolio;
import main.OuterLayerFactory;

import java.io.IOException;

public class SellUseCaseInteractor {

    /**
     * The interactor for selling stocks from a portfolio. This class is used to
     * interact with the API and the portfolio to sell stocks.
     *
     * @param sell The request object containing the portfolio, symbol, and quantity
     * @return The response object containing the portfolio, symbol, quantity, and price
     */

    public SellOutputResponse sellStock(SellInputRequest sell) {

        Portfolio portfolio = sell.getPortfolio();
        String symbol = sell.getSymbol();
        int quantity = sell.getQuantity();

        iEntityDBGateway dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
        StockAPIGateway stockAPIAccess = new StockAPIGateway();
        StockAPIRequest stockAPIRequest = new StockAPIRequest(symbol);
        if(quantity < 1) {
            return new SellOutputResponse(false, "Please enter a positive quantity.");
        }

        try {
            StockAPIResponse stockAPIResponse = stockAPIAccess.getPrice(stockAPIRequest);
            SellType possible = portfolio.sellStock(symbol, stockAPIResponse.getPrice(), quantity);

            if (possible == SellType.ERROR) {
                return new SellOutputResponse(false, "Please enter a valid amount.");
            } else {
                dbGateway.updatePortfolioBalance(
                        portfolio.getName(),
                        portfolio.getBalance(),
                        portfolio.getUsername());

                if (possible == SellType.REMOVE) {
                    dbGateway.deleteStock(
                            symbol,
                            portfolio.getUsername(),
                            portfolio.getName());
                } else {
                    dbGateway.updateStockQuantity(
                            symbol,
                            portfolio.getStockQuantity(symbol),
                            portfolio.getUsername(),
                            portfolio.getName()
                    );
                }

                return new SellOutputResponse(true, "Sale successful!");

            }
        } catch (
                NullPointerException |
                IOException e) {
            return new SellOutputResponse(false, "You do not own any of this stock");
        }
    }
}
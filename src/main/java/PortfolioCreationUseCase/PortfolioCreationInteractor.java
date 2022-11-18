package PortfolioCreationUseCase;

import db.StockDSResponse;
import db.iEntityDBGateway;
import entities.Stock;
import entities.StockFactory;
import entities.User;
import main.OuterLayerFactory;

import java.util.ArrayList;
import java.util.List;

public class PortfolioCreationInteractor {
    private final iEntityDBGateway dbGateway;
    private final StockFactory stockFactory;

    public PortfolioCreationInteractor() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
        stockFactory = new StockFactory();
    }

    public void populatePortfolio(User user, String portfolioName) {
        List<StockDSResponse> stockDSResponses = dbGateway.findPortfolio(portfolioName, user.getUsername()).getStocks();
        List<Stock> stocks = new ArrayList<>();

        for (StockDSResponse stock : stockDSResponses) {
            stocks.add(stockFactory.createStock(
                    stock.getSymbol(),
                    stock.getValue(),
                    stock.getQuantity(),
                    dbGateway));
        }

        user.getPortfolio(portfolioName).pullStocks(stocks);
    }
}
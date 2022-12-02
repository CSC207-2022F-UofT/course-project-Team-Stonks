package BuyStockUseCase;

import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import db.StockDSRequest;
import db.iEntityDBGateway;
import entities.Portfolio;
import main.OuterLayerFactory;

import java.io.IOException;

public class BuyUseCaseInteractor {
    iEntityDBGateway dbGateway;

    public BuyUseCaseInteractor() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }

    /**
     * Receives symbol and quantity input from user, obtains stock price through
     * StockAPIAccess, passes symbol, quantity and price to Portfolio
     *
     * @param req Request with user input
     * @return BuyOutputResponse containing message to be displayed to user
     */

    public BuyOutputResponse buyStock(BuyInputRequest req){
        int buy_quantity = req.getQuantity();
        String symbol = req.getSymbol();
        Portfolio port = req.getPort();

        // Checks if user input is valid, prompts the user if not
        if (buy_quantity < 1) {
            return new BuyOutputResponse(false);
        }

        // Tries to access stock price from API, returns output = null if failure occurs
        StockAPIGateway access = new StockAPIGateway();
        StockAPIResponse res;
        try {
            res = access.getPrice(new StockAPIRequest(symbol));
        } catch(IOException e) {
            return new BuyOutputResponse(null);
        }

        double price = res.getPrice();

        // Passes parameters to Portfolio, outputs results
        BuyType result = port.addStock(symbol, price, buy_quantity);

        if (result == BuyType.FAILED) {
            return new BuyOutputResponse(false);
        }

        if (result == BuyType.NEW){
            dbGateway.addStock(new StockDSRequest(symbol, price, buy_quantity, port.getUsername(), port.getName()));
        }

        dbGateway.updateStockQuantity(symbol, port.getStockQuantity(symbol), port.getUsername(), port.getName());
        dbGateway.updatePortfolioBalance(port.getName(), port.getBalance(), port.getUsername());

        return new BuyOutputResponse(true);
    }
}
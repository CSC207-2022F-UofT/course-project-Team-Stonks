package BuyStockUseCase;

import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import entities.Portfolio;
import java.io.IOException;

public class BuyUseCaseInteractor {

    /**
     * Receives symbol and quantity input from user, obtains stock price through
     * StockAPIAccess, passes symbol, quantity and price to Portfolio
     *
     * @param req Request with user input
     * @return BuyOutputResponse containing message to be displayed to user
     * @throws IOException when there's a connection problem with the API
     */

    BuyOutputResponse buyStock(BuyInputRequest req) throws IOException {
        int buy_quantity = req.getQuantity();
        String symbol = req.getSymbol();
        Portfolio port = req.getPort();

        // Checks if user input is valid, prompts the user if not
        if (buy_quantity < 1) {
            return new BuyOutputResponse(false);
        }

        // Accesses stock price from API
        StockAPIAccess access = new StockAPIAccess();
        StockAPIResponse res = access.getPrice(new StockAPIRequest(symbol));
        double price = res.getPrice();

        // Passes parameters to Portfolio, outputs results
        boolean result = port.addStock(symbol, price, buy_quantity);
        if (result) {
            return new BuyOutputResponse(true);
        } else {
            return new BuyOutputResponse(false);
        }
    }
}

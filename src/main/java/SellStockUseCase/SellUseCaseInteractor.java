package SellStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import entities.Portfolio;
import java.io.IOException;

public class SellUseCaseInteractor {

    /**
     * This method is used to sell stocks from a portfolio
     * @param sell The request object containing the portfolio, symbol, and quantity
     * @return The response object containing the portfolio, symbol, quantity, and price
     * @throws IOException
     */

    public SellOutputResponse sellStock(SellInputRequest sell) throws IOException {
        Portfolio portfolio = sell.getPortfolio();
        String symbol = sell.getSymbol();
        String username = portfolio.getUsername();
        int quantity = sell.getQuantity();
        boolean possible = portfolio.sellStock(symbol, quantity, username);
        StockAPIAccess stockAPIAccess = new StockAPIAccess();
        StockAPIRequest stockAPIRequest = new StockAPIRequest(symbol);
        StockAPIResponse stockAPIResponse = stockAPIAccess.getPrice(stockAPIRequest);
        if(possible){
            double totalValue = stockAPIResponse.getPrice() * quantity;
            return new SellOutputResponse("Sale successful", totalValue, quantity, symbol, true);
        }
        else{
            return new SellOutputResponse("Sale unsuccessful", 0, 0, symbol, false);
        }
    }
}

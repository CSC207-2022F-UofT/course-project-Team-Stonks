package SellStockUseCase;
import entities.Portfolio;

public class SellUseCaseInteractor {

    /**
     * The interactor for selling stocks from a portfolio. This class is used to
     * interact with the API and the portfolio to sell stocks.
     * @param sell The request object containing the portfolio, symbol, and quantity
     * @return The response object containing the portfolio, symbol, quantity, and price
     */

    public SellOutputResponse sellStock(SellInputRequest sell) {

        Portfolio portfolio = sell.getPortfolio();
        String symbol = sell.getSymbol();
        String username = portfolio.getUsername();
        int quantity = sell.getQuantity();

        try {
            boolean possible = portfolio.sellStock(symbol, quantity, username);
            if(possible){
                return new SellOutputResponse("Sale successful!", quantity, symbol, true);
            }
            else{
                return new SellOutputResponse("Please enter a valid amount.", 0, symbol, false);
            }
        }
        catch (NullPointerException e) {
            return new SellOutputResponse("You do not own any of this stock", 0, symbol, false);
        }

    }
}

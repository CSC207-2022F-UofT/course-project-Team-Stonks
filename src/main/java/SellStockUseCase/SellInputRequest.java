package SellStockUseCase;
import entities.Portfolio;

public class SellInputRequest {
    /**
     * This method is used to create a request object
     * @param portfolio The portfolio to sell stocks from
     * @param symbol The symbol of the stock to sell
     * @param quantity The quantity of stocks to sell
     */
    private final Portfolio portfolio;
    private final String symbol;
    private final int quantity;

    public SellInputRequest(Portfolio portfolio, String symbol, int quantity) {
        this.portfolio = portfolio;
        this.symbol = symbol;
        this.quantity = quantity;
    }
    public Portfolio getPortfolio() {
        return portfolio;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getQuantity() {
        return quantity;
    }
}

package SellStockUseCase;
import entities.Portfolio;

public class SellInputRequest {
    /**
     * This class is used to take user's requests for the sell stock use case
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
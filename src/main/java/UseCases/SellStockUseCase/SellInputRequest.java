package UseCases.SellStockUseCase;
import entities.Portfolio;

/**
 * @param portfolio This class is used to take user's requests for the sell stock use case
 */
public record SellInputRequest(Portfolio portfolio, String symbol, int quantity) {
    /**
     * This constructor is used to create a request for the sell stock use case
     *
     * @param portfolio the portfolio to sell from
     * @param symbol    the symbol of the stock to sell
     * @param quantity  the quantity of the stock to sell
     */
    public SellInputRequest {
    }
}
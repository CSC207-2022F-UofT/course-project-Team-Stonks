package APIInterface;

public class StockAPIRequest {
    /**
     * Request model class containing input for an individual price request to the
     * stock price API.
     */
    private final String symbol;
    
    public StockAPIRequest(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

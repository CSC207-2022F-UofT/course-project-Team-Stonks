package APIInterface;

public class StockAPIRequest {
    private String symbol;
    public StockAPIRequest(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

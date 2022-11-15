package APIInterface;

public class StockAPIRequest {
    String symbol;
    public StockAPIRequest(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

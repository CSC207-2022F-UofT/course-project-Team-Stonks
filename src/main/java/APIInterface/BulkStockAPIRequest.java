package APIInterface;

public class BulkStockAPIRequest {
    /**
     * Request model class containing input for a bulk price request to the
     * stock price API.
     */
    private final String[] symbols;

    public BulkStockAPIRequest(String[] symbols) {
        this.symbols = symbols;
    }

    public String[] getSymbols() {
        return symbols;
    }
}

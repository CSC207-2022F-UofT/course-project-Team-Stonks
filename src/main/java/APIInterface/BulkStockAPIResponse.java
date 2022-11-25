package APIInterface;

import java.util.Map;

public class BulkStockAPIResponse {
    /**
     * Response model class containing output from a bulk price request to the
     * stock price API.
     */
    private final Map<String, Double> symbolToPrice;

    public BulkStockAPIResponse(Map<String, Double> symbolToPrice) {
        this.symbolToPrice = symbolToPrice;
    }

    public Map<String, Double> getSymbolToPrice() {
        return this.symbolToPrice;
    }
}
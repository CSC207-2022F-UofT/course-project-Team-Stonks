package APIInterface;

import java.util.HashMap;

public class BulkStockAPIResponse {
    /**
     * Response model class containing output from a bulk price request to the
     * stock price API.
     */
    private HashMap<String, Double> symbolToPrice;

    public BulkStockAPIResponse(HashMap<String, Double> symbolToPrice) {
        this.symbolToPrice = symbolToPrice;
    }

    public HashMap<String, Double> getSymbolToPrice() {
        return this.symbolToPrice;
    }
}

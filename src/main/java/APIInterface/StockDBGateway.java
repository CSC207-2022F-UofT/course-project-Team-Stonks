package APIInterface;

import java.io.IOException;

public interface StockDBGateway {

    /**
     * Returns information from the stock price database
     */

    public StockAPIResponse accessAPI(StockAPIRequest req) throws IOException;
}

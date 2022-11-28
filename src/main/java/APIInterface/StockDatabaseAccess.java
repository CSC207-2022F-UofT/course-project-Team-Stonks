package APIInterface;

import java.io.IOException;

public interface StockDatabaseAccess {

    StockAPIResponse getPrice(StockAPIRequest req) throws IOException;

    BulkStockAPIResponse getBulkPrices(BulkStockAPIRequest req) throws IOException;

    StockAPIResponse getPriceHist(StockAPIRequest req) throws IOException;
}

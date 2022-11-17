package APIInterface;

import java.io.IOException;

public interface StockDatabaseAccess {

    StockAPIResponse accessAPI(StockAPIRequest req) throws IOException;
}

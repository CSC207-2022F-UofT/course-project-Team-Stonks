package APIInterface;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.io.IOException;

public class StockAPIAccess implements StockDatabaseAccess{
    @Override
    public StockAPIResponse accessAPI(StockAPIRequest req) throws IOException {
        Stock stock = YahooFinance.get(req.getSymbol());
        return new StockAPIResponse(stock.getQuote().getPrice().doubleValue());
    }

}

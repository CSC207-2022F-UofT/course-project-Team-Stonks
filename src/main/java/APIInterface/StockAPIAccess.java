package APIInterface;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class StockAPIAccess {

    public StockAPIResponse accessAPI(StockAPIRequest req) throws IOException {
        Stock stock = YahooFinance.get(req.symbol);
        return new StockAPIResponse(stock.getQuote().getPrice().doubleValue());
    }

}

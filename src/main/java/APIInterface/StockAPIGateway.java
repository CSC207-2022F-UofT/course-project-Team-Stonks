package APIInterface;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockAPIGateway implements iStockDatabaseGateway{

    /**
     * @param req StockAPIRequest containing a String representing the symbol of the stock to be searched
     * @return StockAPIResponse containing the price of the stock and a list of historical price information for that stock
     * @throws IOException when there's a connection problem with the API
     */
    @Override
    public StockAPIResponse getPrice(StockAPIRequest req) throws IOException {
        Stock stock = YahooFinance.get(req.getSymbol(), true);
        List<HistoricalQuote> histQuotes = stock.getHistory();
        return new StockAPIResponse(stock.getQuote().getPrice().doubleValue(), histQuotes);
    }

    /**
     * @param req BulkStockAPIRequest containing an array of Strings representing the symbols to be searched
     * @return BulkStockAPIResponse containing a HashMap mapping the stock symbol to its price
     * @throws IOException when there's a connection problem with the API
     */
    @Override
    public BulkStockAPIResponse getBulkPrices(BulkStockAPIRequest req) throws IOException {
        String[] symbols = req.getSymbols();
        Map<String, Stock> stocks = YahooFinance.get(symbols);
        HashMap<String, Double> symbolToPrice = new HashMap<>();
        for (String symbol: symbols) {
            symbolToPrice.put(symbol, stocks.get(symbol).getQuote().getPrice().doubleValue());
        }
        return new BulkStockAPIResponse(symbolToPrice);
    }
}

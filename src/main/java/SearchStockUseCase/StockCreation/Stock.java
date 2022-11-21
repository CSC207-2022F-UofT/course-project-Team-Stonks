package SearchStockUseCase.StockCreation;


import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.util.List;

public class Stock {
    private final String symbol;
    private double value;
    private final List<HistoricalQuote> histData;

    public Stock(String symbol, double value, List<HistoricalQuote> histData) {
        this.symbol = symbol;
        this.value = value;
        this.histData = histData;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public double getValue() {
        return this.value;
    }

    public List<HistoricalQuote> getHistData(){return this.histData;}

    public double updatePrice() throws Exception {
        /* This function should only be called periodically every minute*/
        StockAPIResponse stockAPIResponse;
        try {
            stockAPIResponse = new StockAPIAccess().getPrice(new StockAPIRequest(symbol));
        } catch (IOException e) {
            throw new Exception(String.format("Invalid stock Symbol %s", symbol));
        }
        return stockAPIResponse.getPrice();
    }
}
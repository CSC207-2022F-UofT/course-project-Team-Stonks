package SearchStockUseCase.StockCreation;

import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;

import java.io.IOException;

public class StockFactory {

    public Stock createStock(String symbol) throws Exception {
        StockAPIResponse stockAPIResponse;
        try {
            stockAPIResponse = new StockAPIAccess().getPrice(new StockAPIRequest(symbol));
        } catch (IOException e) {
            throw new Exception(String.format("Invalid stock Symbol %s", symbol));
        }
        return new Stock(symbol, stockAPIResponse.getPrice());
    }
}

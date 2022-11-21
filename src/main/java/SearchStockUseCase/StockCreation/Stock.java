package SearchStockUseCase.StockCreation;


import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;

import java.io.IOException;

public class Stock {
    private final String symbol;
    private double value;
    private int quantity;

    public Stock(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;

    }

    public String getSymbol(){
        return this.symbol;
    }

    public double getValue() {
        return this.value;
    }

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
package SearchStockUseCase;

import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;

import java.io.IOException;


public class ViewStockUseCaseInteractor {
    public boolean searchStock(String symbol) throws Exception {
        try {
            StockAPIGateway access = new StockAPIGateway();
            StockAPIResponse res = access.getPrice(new StockAPIRequest(symbol));
            return true;
        } catch (IOException e) {
            return false;
        }

//        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(symbol);
    }

}
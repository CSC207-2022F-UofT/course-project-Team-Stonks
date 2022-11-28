package SearchStockUseCase;

import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;


public class ViewStockUseCaseInteractor {
    public boolean searchStock(String symbol) throws Exception {
        StockAPIResponse stockResponse = new StockAPIGateway().getPrice(new StockAPIRequest(symbol));
        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(symbol);
        return true;
    }

}
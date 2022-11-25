package SearchStockUseCase;

import APIInterface.StockAPIResponse;
import SearchStockUseCase.StockCreation.Stock;

public class ViewStockPresenter {
    ViewStockPresenter(StockAPIResponse stockResponse, String symbol) throws Exception {
        SearchStockGUI searchStockGUI = new SearchStockGUI(stockResponse, symbol);
    }
}

package SearchStockUseCase;

import SearchStockUseCase.StockCreation.Stock;

public class ViewStockPresenter {
    ViewStockPresenter(Stock stock){
        SearchStockGUI searchStockGUI = new SearchStockGUI(stock);
    }
}

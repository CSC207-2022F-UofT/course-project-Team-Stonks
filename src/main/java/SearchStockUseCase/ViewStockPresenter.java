package SearchStockUseCase;


public class ViewStockPresenter {
    ViewStockPresenter(String symbol) throws Exception {
        SearchStockGUI searchStockGUI = new SearchStockGUI(symbol);
    }
}

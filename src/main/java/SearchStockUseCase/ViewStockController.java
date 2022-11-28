package SearchStockUseCase;

import java.io.IOException;

public class ViewStockController {

    public void searchStock(String symbol) throws IOException {
        ViewStockUseCaseInteractor interactor = new ViewStockUseCaseInteractor();
        interactor.searchStock(symbol);
    }

}

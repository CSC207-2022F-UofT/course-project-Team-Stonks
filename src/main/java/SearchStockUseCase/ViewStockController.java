package SearchStockUseCase;

public class ViewStockController {
    ViewStockController(String symbol){
        ViewStockUseCaseInteractor vsuci = new ViewStockUseCaseInteractor(symbol);
    }
}

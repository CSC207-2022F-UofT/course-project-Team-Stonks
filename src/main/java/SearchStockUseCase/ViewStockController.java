package SearchStockUseCase;

public class ViewStockController {
    ViewStockController(String symbol) throws Exception {
        ViewStockUseCaseInteractor vsuci = new ViewStockUseCaseInteractor(symbol);
    }

    public static void main(String[] args) throws Exception {
        ViewStockController x = new ViewStockController("TSLA");
    }
}

package BuyStockUseCase;

public class BuyStockController {
    /**
     * Controller object for the buy stock use case
     */

    public BuyStockController() {
    }
    public BuyOutputResponse buyStock(BuyInputRequest req) {
        BuyUseCaseInteractor interactor = new BuyUseCaseInteractor();
        return interactor.buyStock(req);
    }
}

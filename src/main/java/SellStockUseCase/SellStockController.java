package SellStockUseCase;

import java.io.IOException;
public class SellStockController {
    /**
     * Create a controller object for the sell stock use case
     */

    public SellStockController() {
    }

    public SellOutputResponse sellStock(SellInputRequest sell){
        SellUseCaseInteractor interactor = new SellUseCaseInteractor();
        return interactor.sellStock(sell);
    }


}

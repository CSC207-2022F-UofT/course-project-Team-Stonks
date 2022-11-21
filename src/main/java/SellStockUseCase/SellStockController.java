package SellStockUseCase;

import java.io.IOException;
public class SellStockController {


    public SellStockController() {
    }

    public SellOutputResponse sellStock(SellInputRequest sell) throws IOException {
        SellUseCaseInteractor interactor = new SellUseCaseInteractor();
        return interactor.sellStock(sell);
    }


}

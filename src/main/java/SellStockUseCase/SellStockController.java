package SellStockUseCase;

import java.io.IOException;
public class SellStockController {
    private final SellUseCaseInteractor interactor;

    public SellStockController() {
        interactor = new SellUseCaseInteractor();
    }

    public SellOutputResponse sellStock(SellInputRequest sell) throws IOException {
        SellUseCaseInteractor sellUseCaseInteractor = new SellUseCaseInteractor();
        return sellUseCaseInteractor.sellStock(sell);
    }


}

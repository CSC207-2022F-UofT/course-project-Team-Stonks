package SellStockUseCase;

import java.io.IOException;
public class SellStockController {
    public SellOutputResponse sellStock(SellInputRequest sell) throws IOException {
        SellUseCaseInteractor sellUseCaseInteractor = new SellUseCaseInteractor();
        return sellUseCaseInteractor.sellStock(sell);
    }


}

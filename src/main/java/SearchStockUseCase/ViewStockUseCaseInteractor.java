package SearchStockUseCase;
import LoginUseCase.UserLoginGUI;
import SearchStockUseCase.StockCreation.*;

import java.io.IOException;


public class ViewStockUseCaseInteractor {
    private final String stockSymbol;
    public ViewStockUseCaseInteractor(String symbol) throws Exception {
        this.stockSymbol = symbol;
        Stock stock;
        try{
            stock = new StockFactory().createStock(symbol);
        }catch(IOException e){
            throw new IOException(String.format("Incorrect symbol: %s", symbol));
        }
        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(stock);
    }

}

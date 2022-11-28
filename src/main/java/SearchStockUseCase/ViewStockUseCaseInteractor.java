package SearchStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;


public class ViewStockUseCaseInteractor {
    public boolean searchStock(String symbol) throws Exception {
        try {
            StockAPIAccess access = new StockAPIAccess();
            StockAPIResponse res = access.getPrice(new StockAPIRequest(symbol));
            return true;
        } catch (IOException e) {
            return false;
        }

//        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(symbol);
    }

}

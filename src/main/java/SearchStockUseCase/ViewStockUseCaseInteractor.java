package SearchStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;


public class ViewStockUseCaseInteractor {
    public boolean searchStock(String symbol) throws Exception {
        StockAPIResponse stockResponse = new StockAPIAccess().getPrice(new StockAPIRequest(symbol));
//        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(symbol);
        return true;
    }

}

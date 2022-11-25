package SearchStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import LoginUseCase.UserLoginGUI;
import SearchStockUseCase.StockCreation.*;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;


public class ViewStockUseCaseInteractor {
    public ViewStockUseCaseInteractor(String symbol, Calendar from, Interval stockPriceInterval) throws Exception {
        //Calendar.getInstance().add(), Calendar.getInstance(), Interval
        StockAPIResponse stockResponse = new StockAPIAccess().getPriceHist(new StockAPIRequest(symbol, from, stockPriceInterval));
        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(stockResponse, symbol);
    }

}

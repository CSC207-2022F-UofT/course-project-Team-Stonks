package SearchStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.Interval;
import java.util.Calendar;


public class ViewStockUseCaseInteractor {
    public ViewStockUseCaseInteractor(String symbol) throws Exception {
        //Calendar.getInstance().add(), Calendar.getInstance(), Interval
        StockAPIResponse stockResponse = new StockAPIAccess().getPrice(new StockAPIRequest(symbol));
        ViewStockPresenter viewStockPresenter = new ViewStockPresenter(symbol);
    }

}

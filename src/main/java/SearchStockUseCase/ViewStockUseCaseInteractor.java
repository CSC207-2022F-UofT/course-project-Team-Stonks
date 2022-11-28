package SearchStockUseCase;
import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;


public class ViewStockUseCaseInteractor{
    private StockAPIResponse stock;
    private Calendar from = Calendar.getInstance();
    private Interval stockPriceInterval = Interval.DAILY;

    public boolean searchStock(String symbol){
        System.out.println(symbol);
        this.from.add(Calendar.DATE, -7); //Date of the last 7 days
        try {
            this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(symbol, this.from, this.stockPriceInterval));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}

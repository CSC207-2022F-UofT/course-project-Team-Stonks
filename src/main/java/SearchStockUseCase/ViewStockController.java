package SearchStockUseCase;

import yahoofinance.histquotes.Interval;

import java.util.Calendar;

public class ViewStockController {
    ViewStockController(String symbol, Calendar from, Interval stockPriceInterval) throws Exception {
        ViewStockUseCaseInteractor vsuci = new ViewStockUseCaseInteractor(symbol, from, stockPriceInterval);
    }

    public static void main(String[] args) throws Exception {
        //Calendar.getInstance().add(), Calendar.getInstance(), Interval
        Calendar from = Calendar.getInstance();
        from.add(Calendar.DATE, -7);
        Calendar to = Calendar.getInstance();
        System.out.println(Calendar.getInstance());
        ViewStockController x = new ViewStockController("TSLA", from, Interval.DAILY);
    }
}

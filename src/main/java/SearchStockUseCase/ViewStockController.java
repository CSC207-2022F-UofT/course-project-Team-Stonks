package SearchStockUseCase;

import yahoofinance.histquotes.Interval;

import java.util.Calendar;

public class ViewStockController {
    ViewStockController(String symbol) throws Exception {
        ViewStockUseCaseInteractor vsuci = new ViewStockUseCaseInteractor(symbol);
    }

    public static void main(String[] args) throws Exception {
        //Calendar.getInstance().add(), Calendar.getInstance(), Interval
//        Calendar from = Calendar.getInstance();
//        from.add(Calendar.MONTH, -7);
//        Calendar to = Calendar.getInstance();
//        System.out.println(from.getTime());
        ViewStockController x = new ViewStockController("TSLA");
    }
}

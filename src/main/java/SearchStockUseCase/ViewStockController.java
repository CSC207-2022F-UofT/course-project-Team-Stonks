package SearchStockUseCase;

import yahoofinance.histquotes.Interval;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class ViewStockController {
    ViewStockController(String symbol) throws Exception {
        ViewStockUseCaseInteractor vsuci = new ViewStockUseCaseInteractor();
        boolean isValid = vsuci.searchStock(symbol);
    }

}

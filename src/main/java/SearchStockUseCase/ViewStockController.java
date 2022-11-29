package SearchStockUseCase;

import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class ViewStockController {
    private final ViewStockUseCaseInteractor interactor = new ViewStockUseCaseInteractor();;

    public void searchStock(String symbol) throws IOException {
        interactor.searchStock(symbol);
    }

    public DefaultTableModel updateTable(){
        // Column Names
        String[] columnNames = {"Date", "Stock Price"};
        String[][] data = interactor.sortHistoricalData();
        return new DefaultTableModel(data, columnNames);
    }

}

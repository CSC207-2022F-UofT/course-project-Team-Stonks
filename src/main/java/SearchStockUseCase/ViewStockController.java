package SearchStockUseCase;

import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class ViewStockController {
    private final ViewStockUseCaseInteractor interactor;

    public ViewStockController(String symbol){
         this.interactor = new ViewStockUseCaseInteractor(symbol);
    }

    public void stockIsValid() throws Exception {
        interactor.isValidStock();
    }

    public void searchStock() throws IOException {
        interactor.searchStock();
    }

    public DefaultTableModel updateTable(){
        // Column Names
        String[] columnNames = {"Date", "Stock Price"};
        String[][] data = interactor.sortHistoricalData();
        return new DefaultTableModel(data, columnNames);
    }

}

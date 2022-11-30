package SearchStockUseCase;


import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;


public interface iViewStockGUI {
    void yearlyButtonAction(Runnable onYearlyButton);

    void addBuyStockAction(Runnable onBuyStock);
    void addSellStockAction(Runnable onSellStock);
    double updatePrice() throws Exception;
    void updateValues() throws IOException;
    void todayButtonAction(Runnable onTodayButton);
    void weeklyButtonAction(Runnable onWeeklyButton);
    void addBackAction(Runnable onBack);
    String stockMarketStatus();
    void updateTable(DefaultTableModel tableModel);
    void close();
    String getStockSymbol();
    void setHistData(List<HistoricalQuote> historicalQuotes);
    void setStockPrice(double stockPrice);
    void loadLabels();
}

package SearchStockUseCase;
import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class ViewStockUseCaseInteractor{
    private StockAPIResponse stock;
    private final String stockSymbol;
    private final Calendar from = Calendar.getInstance();
    private final Interval stockPriceInterval = Interval.DAILY;

    public ViewStockUseCaseInteractor(String symbol){
        this.stockSymbol = symbol;
    }

    public void isValidStock() throws Exception {
        //Checking is API throws error or not
        try{
            new StockAPIGateway().getPrice(new StockAPIRequest(this.stockSymbol));
        }catch (IOException e){
            throw new Exception("Invalid stock symbol");
        }
    }

    public void searchStock() throws IOException {
        this.from.add(Calendar.DATE, -7); //Date of the last 7 days
        this.stock = new StockAPIGateway().getPriceHist(new StockAPIRequest(this.stockSymbol, this.from, this.stockPriceInterval));
    }

    public String[][] sortHistoricalData(){
        try {
            this.stock = new StockAPIGateway().getPriceHist(new StockAPIRequest(this.stockSymbol, this.from, this.stockPriceInterval));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<HistoricalQuote> histData = stock.getHistData();
        //Setting up the JTable
        String[][] data = new String[histData.size()][2];
        int row = 0;
        for (HistoricalQuote q : histData) {
            data[row][0] = new SimpleDateFormat("dd/MM/yyyy").format(q.getDate().getTime());
            data[row][1] = new DecimalFormat("0.00").format(q.getClose());
            row++;
        }
        return data;
    }

}

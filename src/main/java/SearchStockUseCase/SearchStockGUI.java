package SearchStockUseCase;

import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


public class SearchStockGUI extends JFrame{
    private StockAPIResponse stock;
    private Calendar from = Calendar.getInstance();
    private Interval stockPriceInterval = Interval.DAILY;
    private final String stockSymbol;
    private List<HistoricalQuote> histData;
    private JPanel mainPanel;
    private JLabel stockLabel;
    private JButton buyStockButton;
    private JButton sellStockButton;
    private JPanel graph;
    private JButton todayButton;
    private JButton weekButton;
    private JButton yearButton;
    private JPanel infoPanel;
    private JLabel currentPrice;
    private JLabel up_down;
    private JLabel curr_high;
    private JLabel curr_low;
    private JButton refreshButton;
    private JTable priceTable;
    private JScrollPane tableScrollPane;

    SearchStockGUI(String symbol) throws Exception {
        priceTable.setDefaultEditor(Object.class, null); //Disabling cell editing

        this.from.add(Calendar.DATE, -7); //Date of the last 7 days
        this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(symbol, this.from, this.stockPriceInterval));
        this.stockSymbol = symbol;
        this.histData = stock.getHistData();

        //Setting up labels
        HistoricalQuote latestValues = histData.get(histData.size() - 1);
        curr_high.setText("High: " +  new DecimalFormat("0.00").format(latestValues.getHigh()));
        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(latestValues.getLow()));
        currentPrice.setText("Current: " + new DecimalFormat("0.00").format(this.stock.getPrice()));

        HistoricalQuote previousDayValues = histData.get(histData.size() - 1);
        double last_close = previousDayValues.getClose().doubleValue();
        up_down.setText("Up/Down: " + new DecimalFormat("0.00").format(updatePrice() - last_close));

        stockLabel.setText(this.stockSymbol + stockMarketStatus());


        //Setting up Buttons
        buyStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buyStockButton, "BuY Stock");
            }
        });
        sellStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(sellStockButton, "Sell Stock");
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateValues();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        updateTable();

        //Setting up JFrame
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        todayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    todayButtonAction();
                    updateTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        weekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    weeklyButtonAction();
                    updateTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        yearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    monthlyButtonAction();
                    updateTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    private void updateTable() {
        //Setting up the JTable
        String[][] data = new String[this.histData.size()][2];
        // Column Names
        String[] columnNames = { "Date", "Stock Price"};

        int row = 0;
        for (HistoricalQuote q:this.histData) {
            data[row][0] = new SimpleDateFormat("dd/MM/yyyy").format(q.getDate().getTime());
            data[row][1] = new DecimalFormat("0.00").format(q.getClose());
            row++;
        }
        // Initializing the JTable
        priceTable.setModel(new DefaultTableModel(data,columnNames));
    }

    public double updatePrice() throws Exception {
        /* This function should only be called periodically every minute*/
        StockAPIResponse stockAPIResponse;
        try {
            stockAPIResponse = new StockAPIAccess().getPrice(new StockAPIRequest(this.stockSymbol));
        } catch (IOException e) {
            throw new Exception(String.format("Invalid stock Symbol %s", this.stockSymbol));
        }
        return stockAPIResponse.getPrice();
    }

    private void updateValues() throws IOException {
        //Getting updated values from API
        this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(this.stockSymbol, this.from, this.stockPriceInterval));
        this.histData = this.stock.getHistData();

        //Setting up labels
        HistoricalQuote latestValues = histData.get(histData.size() - 1);
        curr_high.setText("High: " +  new DecimalFormat("0.00").format(latestValues.getHigh()));
        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(latestValues.getLow()));
        currentPrice.setText("Current: " + new DecimalFormat("0.00").format(this.stock.getPrice()));
    }

    private void todayButtonAction() throws IOException {
        Calendar dailyFrom = Calendar.getInstance();
        dailyFrom.add(Calendar.DATE, -7);
        Interval dailyInterval = Interval.DAILY;
        this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(this.stockSymbol, dailyFrom, dailyInterval));
        this.histData = this.stock.getHistData();
    }

    private void weeklyButtonAction() throws IOException {
        Calendar weeklyFrom = Calendar.getInstance();
        weeklyFrom.setFirstDayOfWeek(Calendar.MONDAY);
        weeklyFrom.add(Calendar.MONTH, -2);
        Interval weeklyInterval = Interval.WEEKLY;
        this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(this.stockSymbol, weeklyFrom, weeklyInterval));
        this.histData = this.stock.getHistData();
    }

    private void monthlyButtonAction() throws IOException {
        Calendar monthlyFrom = Calendar.getInstance();
        monthlyFrom.add(Calendar.YEAR, -7);
        Interval monthlyInterval = Interval.MONTHLY;
        this.stock = new StockAPIAccess().getPriceHist(new StockAPIRequest(this.stockSymbol, monthlyFrom, monthlyInterval));
        this.histData = this.stock.getHistData();
    }

    private String stockMarketStatus(){
        if (LocalDate.EPOCH.getDayOfWeek() == DayOfWeek.SATURDAY||LocalDate.EPOCH.getDayOfWeek() == DayOfWeek.SUNDAY){
            return "(Closed)";
        }else if(9 > LocalTime.MAX.getHour() ||  LocalTime.MAX.getHour() > 16){
            return "(Closed)";
        }
        return "";
    }

}

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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


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

        stockLabel.setText(this.stockSymbol);


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
        String[][] data = new String[histData.size()][2];
        int row = 0;
        for (HistoricalQuote q:histData) {
            data[row][0] = new SimpleDateFormat("dd/MM/yyyy").format(q.getDate().getTime());
            data[row][1] = new DecimalFormat("0.00").format(q.getClose());
            row++;
        }
        // Data to be displayed in the JTable

        // Column Names
        String[] columnNames = { "Date", "Stock Price"};

        // Initializing the JTable
        priceTable.setModel(new DefaultTableModel(data,columnNames));

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
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

}

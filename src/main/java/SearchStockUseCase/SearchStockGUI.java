package SearchStockUseCase;

import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class SearchStockGUI extends JFrame{
    private StockAPIResponse stock;
    private String stockSymbol;
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

    SearchStockGUI(StockAPIResponse stockResponse, String symbol) throws Exception {
        this.stock = stockResponse;
        this.stockSymbol = symbol;
        this.histData = stock.getHistData();
        curr_high.setText("High: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getHigh()));
        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getLow()));
        double last_close = histData.get(histData.size() - 2).getClose().doubleValue();
        up_down.setText("Up/Down: " + new DecimalFormat("0.00").format(updatePrice() - last_close));
        stockLabel.setText(this.stockSymbol);
        currentPrice.setText("Current: " + new DecimalFormat("0.00").format(updatePrice()));
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
        }
        );
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                updateValues();
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

//    private void updateValues() {
//        curr_high.setText("High: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getHigh()));
//        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getLow()));
//        stockLabel.setText(stock.getSymbol());
//        try {
//            currentPrice.setText("Current: " + new DecimalFormat("0.00").format(stock.updatePrice()));
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }

}

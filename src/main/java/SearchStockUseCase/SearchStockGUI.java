package SearchStockUseCase;

import SearchStockUseCase.StockCreation.*;
import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;


public class SearchStockGUI extends JFrame{
    private Stock stock;
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

    SearchStockGUI(Stock searchStock){
        this.stock = searchStock;
        this.histData = stock.getHistData();
        curr_high.setText("High: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getHigh()));
        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getLow()));
        double last_close = histData.get(histData.size() - 2).getClose().doubleValue();
        up_down.setText("Up/Down: " + new DecimalFormat("0.00").format(stock.getValue() - last_close));
        stockLabel.setText(stock.getSymbol());
        currentPrice.setText("Current: " + new DecimalFormat("0.00").format(stock.getValue()));
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
                updateValues();
            }
        });
        for (HistoricalQuote q:histData) {
            System.out.println(q);
        }
        // Data to be displayed in the JTable
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };

        // Initializing the JTable
        priceTable.setModel(new DefaultTableModel(data,columnNames));

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void updateValues() {
        curr_high.setText("High: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getHigh()));
        curr_low.setText("Low: " +  new DecimalFormat("0.00").format(histData.get(histData.size() - 1).getLow()));
        stockLabel.setText(stock.getSymbol());
        try {
            currentPrice.setText("Current: " + new DecimalFormat("0.00").format(stock.updatePrice()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

package SearchStockUseCase;

import SearchStockUseCase.StockCreation.*;
import yahoofinance.histquotes.HistoricalQuote;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class SearchStockGUI extends JFrame{
    final private Stock stock;
    final private List<HistoricalQuote> histData;
    private JPanel mainPanel;
    private JLabel stockLabel;
    private JButton buyStockButton;
    private JButton sellStockButton;
    private JPanel graph;
    private JButton todayButton;
    private JButton weekButton;
    private JButton yearButton;
    private JPanel plot;
    private JPanel infoPanel;
    private JLabel currentPrice;
    private JLabel up_down;
    private JLabel curr_high;
    private JLabel curr_low;
    private JButton refreshButton;

    SearchStockGUI(Stock searchStock){
        this.stock = searchStock;
        histData = stock.getHistData();
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

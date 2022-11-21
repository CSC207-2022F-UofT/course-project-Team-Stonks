package SearchStockUseCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class SearchStockGUI extends JFrame{
    final private String stockSymbol;
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

    SearchStockGUI(String symbol){
        this.stockSymbol = symbol;
        stockLabel.setText(stockSymbol);
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

        graph.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        SearchStockGUI s = new SearchStockGUI("TSLA");
        s.setContentPane(s.mainPanel);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setSize(500,500);
        s.pack();
        s.setVisible(true);
    }

}

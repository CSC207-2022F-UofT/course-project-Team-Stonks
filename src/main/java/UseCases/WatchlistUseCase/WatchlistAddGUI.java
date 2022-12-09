package UseCases.WatchlistUseCase;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

public class WatchlistAddGUI extends JFrame {
    
    private final WatchlistController controller;

    public WatchlistAddGUI(String username) {
        super();
     
        JButton backButton = new JButton("Cancel");
        JButton addButton = new JButton("Add");
        JTextField symbolField = new JTextField();
        JTextField valueField = new JTextField();

        String[] conditions = { "Above", "Below" };
        JComboBox<String> conditionField = new JComboBox<>(conditions);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(backButton);
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(10, 1));
        fieldPanel.add(new JLabel("Symbol:"));
        fieldPanel.add(symbolField);
        fieldPanel.add(new JLabel("Value:"));
        fieldPanel.add(valueField);
        fieldPanel.add(new JLabel("Condition:"));
        fieldPanel.add(conditionField);
        buttonPanel.add(fieldPanel);
        fieldPanel.setPreferredSize(new Dimension(300, 100));
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        setSize(600, 600);
        setLocationRelativeTo(null);
        add(fieldPanel, BorderLayout.CENTER);

        controller = new WatchlistController();

        backButton.addActionListener(event -> dispose());

        addButton.addActionListener(event -> {
            if (!isValidStockSymbol(symbolField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid stock symbol.");
                return;
            }

            String symbol = symbolField.getText();
            Float value = Float.parseFloat(valueField.getText());
            String condition = (String) conditionField.getSelectedItem();

         
            //* */
            controller.addStockToWatchlist(username, symbol, value, condition);

            JOptionPane.showMessageDialog(null, "Stock added to watchlist.");
            dispose();
        });

        setTitle("Add/Remove Stock to track with a Watchlist");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(600, 600);
        setVisible(true);
    }

    /**
     * isValidStockSymbol(String symbol)
     * This function takes in a String representing a stock symbol, and returns a
     * boolean value indicating whether the symbol is valid.
     * It does this by making an HTTP request to the Yahoo Finance website for the
     * given stock symbol and checking whether the response contains a certain
     * string.
     * If the string is found, the function returns true; otherwise, it returns
     * false.
     * 
     * @param symbol stock symbol to check if valid
     * @return boolean
     */
    public static boolean isValidStockSymbol(String symbol) {
        try {
            URL url = new URL("https://finance.yahoo.com/quote/" + symbol);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();

            String result = sb.toString();
            return result.contains("QuoteSummaryStore");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

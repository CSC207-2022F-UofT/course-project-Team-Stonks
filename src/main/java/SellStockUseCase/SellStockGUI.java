package SellStockUseCase;

import javax.swing.*;

public class SellStockGUI extends JFrame implements iSellStockGUI{
    private JPanel SellStockPanel;
    private JTextField quantityBox;
    private JButton sellButton;
    private JButton backButton;
    private JLabel symbol;

    public SellStockGUI(String symbol) {
        super();
        this.setContentPane(SellStockPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.symbol.setText(symbol);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void addSellAction(Runnable onSell) {
        sellButton.addActionListener(e -> onSell.run());
    }
    @Override
    public void addGoBackAction(Runnable onBack) {
        backButton.addActionListener(e -> onBack.run());
    }
    @Override
    public void close() {
        dispose();
    }
    @Override
    public void displayQuantityFailure(){
        JOptionPane.showMessageDialog(
                null,
                "Please enter a valid amount.");
    }
    @Override
    public void displayConnectionFailure() {
        JOptionPane.showMessageDialog(
                null,
                "There was a problem connecting to the stock price service.");
    }
    @Override
    public int getQuantity() throws NumberFormatException {
        return Integer.parseInt(quantityBox.getText());
    }
    public void displaySuccess(){
        JOptionPane.showMessageDialog(
                null,
                "Sale successful!");
    }
    public String getSymbol() {
        return symbol.getText();
    }

}



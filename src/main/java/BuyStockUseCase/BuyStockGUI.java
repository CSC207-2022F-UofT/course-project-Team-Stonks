package BuyStockUseCase;

import javax.swing.*;

public class BuyStockGUI extends JFrame implements iBuyStockGUI{
    private JButton buyButton;
    private JTextField quantityField;
    private JLabel buyStockLabel;
    private JLabel quantityLabel;
    private JLabel responseLabel;
    private JLabel symbolLabel;
    private JButton goBackButton;

    public BuyStockGUI (String symbol) {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.symbolLabel.setText(symbol);
        this.responseLabel.setText("");
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void addBuyAction(Runnable onLogin) {
        buyButton.addActionListener(e -> onLogin.run());
    }

    @Override
    public void addGoBackAction(Runnable onBack) {
        goBackButton.addActionListener(e -> onBack.run());
    }

    @Override
    public void close() {
        dispose();
    }

    @Override
    public void displayBalanceFailure(){
        this.responseLabel.setText("Insufficient balance.");
    }

    @Override
    public void displayConnectionFailure(){
        this.responseLabel.setText("There was a problem connecting to the stock price service.");
    }

    @Override
    public void displayInvalidInputFailure(){
        this.responseLabel.setText("Please enter a positive integer.");
    }

    @Override
    public void displaySuccess(){
        this.responseLabel.setText("Purchase successful!");
    }

    @Override
    public String getSymbol() {
        return this.symbolLabel.getText();
    }

    @Override
    public int getQuantity() throws NumberFormatException{
        return Integer.parseInt(this.quantityField.getText());
    }
}

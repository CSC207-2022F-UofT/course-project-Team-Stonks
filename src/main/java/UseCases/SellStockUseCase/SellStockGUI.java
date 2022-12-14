package UseCases.SellStockUseCase;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class SellStockGUI extends JFrame implements SellStockView {
    /**
     * This is the GUI for the sell stock use case
     */
    private JPanel SellStockPanel;
    private JTextField quantityBox;
    private JButton sellButton;
    private JButton backButton;
    private JLabel symbolLabel;
    private final String symbol;
    private int quantity;

    public SellStockGUI(String symbol, int quantity) {
        super();
        this.symbol = symbol;
        this.quantity = quantity;
        this.setContentPane(SellStockPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.symbolLabel.setText(symbol + " (Currently have: " + quantity + ")");
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
    public void displayQuantityFailure() {
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

    public void displaySuccess() {
        JOptionPane.showMessageDialog(
                null,
                "Sale successful! You have sold " + quantityBox.getText() + " shares of "
                        + symbol + ".");
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public void updateQuantityLabel(int quant) {
        this.quantity -= quant;
        this.symbolLabel.setText(symbol + " (Currently have: " + this.quantity + ")");
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        SellStockPanel = new JPanel();
        SellStockPanel.setLayout(new GridLayoutManager(7, 8, new Insets(40, 40, 40, 40), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        SellStockPanel.add(panel1, new GridConstraints(2, 0, 4, 8, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        quantityBox = new JTextField();
        panel1.add(quantityBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Quantity");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        SellStockPanel.add(panel2, new GridConstraints(6, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sellButton = new JButton();
        sellButton.setText("Sell");
        panel2.add(sellButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        panel2.add(backButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, Font.BOLD, 26, label2.getFont());
        if (label2Font != null)
            label2.setFont(label2Font);
        label2.setText("Sell Stock");
        SellStockPanel.add(label2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        symbolLabel = new JLabel();
        symbolLabel.setText("_");
        SellStockPanel.add(symbolLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null)
            return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return SellStockPanel;
    }

}
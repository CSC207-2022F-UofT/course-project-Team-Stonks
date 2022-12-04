package BuyStockUseCase;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import entities.Portfolio;
import entities.Stock;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.Map;

public class PortfolioGUI extends JFrame implements iPortfolioGUI {
    /**
     * GUI where the user can view their portfolio information
     */
    private final Portfolio port;
    private JLabel portfolioName;
    private JPanel portfolioPanel;
    private JLabel balance;
    private JButton backButton;
    private JLabel username;
    private JComboBox<String> stockComboBox;
    private JButton searchButton;
    private JTextField searchField;
    private JButton makeCompetitivePortfolioButton;
    private JLabel netValue;

    /**
     * GUI where the user can view their portfolio information
     */
    public PortfolioGUI(Portfolio port, String username, boolean isComp) {
        super();

        this.port = port;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(portfolioPanel);
        this.pack();
        this.setVisible(true);
        this.portfolioName.setText(this.port.getName());
        this.netValue.setText("Net Value: $" + port.getNetValue());
        this.balance.setText("Balance: $" + port.getBalance());
        this.username.setText("Logged in as: " + username);

        if (isComp) {
            addCompText();
            portfolioPanel.remove(makeCompetitivePortfolioButton);
        }

        Map<String, Stock> map = port.getSymbolToStock();
        for (String str : map.keySet()) {
            String str2 = str + ":" + map.get(str).getQuantity();
            stockComboBox.addItem(str2);
        }
    }


    @Override
    public void addSearchAction(Runnable onLogin) {
        searchButton.addActionListener(e -> onLogin.run());
    }

    @Override
    public void addBackAction(Runnable onBack) {
        backButton.addActionListener(e -> onBack.run());
    }

    @Override
    public String getSearchField() {
        return this.searchField.getText();
    }

    @Override
    public void addMakeCompPortfolioAction(Runnable onMakeCompPortfolio) {
        makeCompetitivePortfolioButton.addActionListener(e -> onMakeCompPortfolio.run());
    }

    @Override
    public void close() {
        dispose();
    }

    @Override
    public void removeCompPortfolioButton() {
        portfolioPanel.remove(makeCompetitivePortfolioButton);
        addCompText();
    }

    @Override
    public void invalidStockMessage(String symbol) {
        JOptionPane.showMessageDialog(null, "Invalid stock symbol: " + symbol);
    }

    private void addCompText() {
        this.portfolioName.setText(portfolioName.getText() + " (Competitive Portfolio)");
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
        portfolioPanel = new JPanel();
        portfolioPanel.setLayout(new GridLayoutManager(3, 7, new Insets(0, 0, 0, 0), -1, -1));
        portfolioPanel.setMinimumSize(new Dimension(400, 200));
        portfolioPanel.setPreferredSize(new Dimension(700, 500));
        username = new JLabel();
        Font usernameFont = this.$$$getFont$$$(null, Font.BOLD, 14, username.getFont());
        if (usernameFont != null)
            username.setFont(usernameFont);
        username.setText("Logged in as: ");
        portfolioPanel.add(username, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        portfolioPanel.add(backButton, new GridConstraints(2, 5, 1, 2, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        portfolioPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        portfolioName = new JLabel();
        Font portfolioNameFont = this.$$$getFont$$$(null, Font.BOLD, 18, portfolioName.getFont());
        if (portfolioNameFont != null)
            portfolioName.setFont(portfolioNameFont);
        portfolioName.setText("Portfolio name:");
        panel1.add(portfolioName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        balance = new JLabel();
        Font balanceFont = this.$$$getFont$$$(null, Font.BOLD, 18, balance.getFont());
        if (balanceFont != null)
            balance.setFont(balanceFont);
        balance.setText("Balance: $");
        panel1.add(balance, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        portfolioPanel.add(panel2, new GridConstraints(0, 1, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, 18, label1.getFont());
        if (label1Font != null)
            label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setText("Stocks:");
        panel2.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        stockComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Stock: Quantity");
        stockComboBox.setModel(defaultComboBoxModel1);
        panel2.add(stockComboBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setText("Search");
        portfolioPanel.add(searchButton, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        searchField = new JTextField();
        portfolioPanel.add(searchField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        makeCompetitivePortfolioButton = new JButton();
        makeCompetitivePortfolioButton.setText("Make Competitive Portfolio");
        portfolioPanel.add(makeCompetitivePortfolioButton, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        netValue = new JLabel();
        Font netValueFont = this.$$$getFont$$$(null, Font.BOLD, 18, netValue.getFont());
        if (netValueFont != null)
            netValue.setFont(netValueFont);
        netValue.setText("Net Value: $");
        portfolioPanel.add(netValue, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return portfolioPanel;
    }

}
package UseCases.PortfolioCreationUseCase;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class PortfolioCreationGUI extends JFrame implements PortfolioCreationView {
    private JPanel portfolioPanel;
    private JButton btnBack;
    private JButton btnContinue;
    private JTextField txtPortfolioName;
    private JLabel textPortfolioName;

    public PortfolioCreationGUI() {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(portfolioPanel);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public String getNewPortfolioName() {
        return txtPortfolioName.getText();
    }

    @Override
    public void addCreatePortfolioAction(Runnable onCreate) {
        btnContinue.addActionListener(e -> onCreate.run());
    }

    @Override
    public void addBackAction(Runnable onBack) {
        btnBack.addActionListener(e -> onBack.run());
    }

    @Override
    public void presentNameInvalidError() {
        JOptionPane.showMessageDialog(null, "Portfolio Name Invalid!");
    }

    @Override
    public void presentDuplicateNameError() {
        JOptionPane.showMessageDialog(null, "There already exists a portfolio with this name!");
    }

    @Override
    public void close() {
        dispose();
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
        portfolioPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        portfolioPanel.setMinimumSize(new Dimension(474, 369));
        btnBack = new JButton();
        Font btnBackFont = this.$$$getFont$$$(null, -1, 16, btnBack.getFont());
        if (btnBackFont != null) btnBack.setFont(btnBackFont);
        btnBack.setText("Go Back");
        portfolioPanel.add(btnBack, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnContinue = new JButton();
        Font btnContinueFont = this.$$$getFont$$$(null, -1, 16, btnContinue.getFont());
        if (btnContinueFont != null) btnContinue.setFont(btnContinueFont);
        btnContinue.setText("Make New Portfolio");
        portfolioPanel.add(btnContinue, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textPortfolioName = new JLabel();
        Font textPortfolioNameFont = this.$$$getFont$$$(null, -1, 16, textPortfolioName.getFont());
        if (textPortfolioNameFont != null) textPortfolioName.setFont(textPortfolioNameFont);
        textPortfolioName.setText("Portfolio Name");
        portfolioPanel.add(textPortfolioName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtPortfolioName = new JTextField();
        Font txtPortfolioNameFont = this.$$$getFont$$$(null, -1, 16, txtPortfolioName.getFont());
        if (txtPortfolioNameFont != null) txtPortfolioName.setFont(txtPortfolioNameFont);
        portfolioPanel.add(txtPortfolioName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
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
package UseCases.PortfolioCreationUseCase;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import WatchlistUseCase.WatchlistGUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Locale;
import java.util.List;

public class UserGUI extends JFrame implements UserView {
    private JPanel userPanel;
    private JLabel username;
    private JList<String> portfolios;
    private JLabel portfoliosTitle;
    private JButton logOut;
    private JLabel lastLogin;
    private JButton createPortfolio;
    private JButton goToLeaderboard;
    private JButton goToWatchList;

    public UserGUI(String username, List<String> portfolioNames, Date lastLogin) {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userPanel);
        this.pack();
        this.setVisible(true);

        this.username.setText("Welcome: " + username);
        this.lastLogin.setText("Last login: " + lastLogin);

        DefaultListModel<String> dPortfolios = new DefaultListModel<>();
        dPortfolios.addAll(portfolioNames);
        portfolios.setModel(dPortfolios);
        goToWatchList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                WatchlistGUI watchlistGUI = new WatchlistGUI(username);
                watchlistGUI.setVisible(true);
            }
        });
 
    }

    @Override
    public void addLogoutAction(Runnable onLogout) {
        logOut.addActionListener(e -> onLogout.run());
    }

    @Override
    public void addPortfolioSelectedAction(Runnable onPortfolioSelected) {
        portfolios.addListSelectionListener(e -> onPortfolioSelected.run());
    }

    @Override
    public void createPortfolioAction(Runnable onCreatePortfolio) {
        createPortfolio.addActionListener(e -> onCreatePortfolio.run());
    }

    @Override
    public void goToLeaderboardAction(Runnable onGoToLeaderboard) {
        goToLeaderboard.addActionListener(e -> onGoToLeaderboard.run());
    }

    public void goToWatchList(Runnable onGoToWatchList) {
        goToWatchList.addActionListener(e -> onGoToWatchList.run());
    }

    @Override
    public String getPortfolioSelected() {
        return portfolios.getSelectedValue();
    }

    /**
     *
     */
    @Override
    public void close() {
        dispose();
    }

    @Override
    public boolean confirmPortfolioMessage(String portfolioName) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to view portfolio: " + portfolioName, "Selection", dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
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
        userPanel = new JPanel();
        userPanel.setLayout(new GridLayoutManager(4, 4, new Insets(1, 1, 1, 1), -1, -1));
        userPanel.setAlignmentX(0.5f);
        userPanel.setForeground(new Color(-67841));
        userPanel.setMinimumSize(new Dimension(650, 400));
        userPanel.setPreferredSize(new Dimension(800, 500));
        userPanel.setRequestFocusEnabled(true);
        userPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        logOut = new JButton();
        logOut.setText("Logout");
        userPanel.add(logOut, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setAutoscrolls(false);
        userPanel.add(panel1, new GridConstraints(1, 0, 2, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(50, 400), null, 0, false));
        portfoliosTitle = new JLabel();
        Font portfoliosTitleFont = this.$$$getFont$$$(null, Font.BOLD, 22, portfoliosTitle.getFont());
        if (portfoliosTitleFont != null) portfoliosTitle.setFont(portfoliosTitleFont);
        portfoliosTitle.setText("Portfolios:");
        panel1.add(portfoliosTitle, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(324, 10), null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        portfolios = new JList();
        portfolios.setBackground(new Color(-67841));
        portfolios.setDropMode(DropMode.USE_SELECTION);
        portfolios.setFocusable(true);
        Font portfoliosFont = this.$$$getFont$$$(null, -1, 20, portfolios.getFont());
        if (portfoliosFont != null) portfolios.setFont(portfoliosFont);
        portfolios.setForeground(new Color(-14518587));
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Test Obnj");
        defaultListModel1.addElement("Portfolio 2");
        portfolios.setModel(defaultListModel1);
        portfolios.setOpaque(true);
        portfolios.setSelectionMode(2);
        scrollPane1.setViewportView(portfolios);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        userPanel.add(panel2, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(50, 20), null, 0, false));
        username = new JLabel();
        Font usernameFont = this.$$$getFont$$$(null, Font.BOLD, 26, username.getFont());
        if (usernameFont != null) username.setFont(usernameFont);
        username.setText("");
        panel2.add(username, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lastLogin = new JLabel();
        Font lastLoginFont = this.$$$getFont$$$(null, Font.BOLD, 18, lastLogin.getFont());
        if (lastLoginFont != null) lastLogin.setFont(lastLoginFont);
        lastLogin.setHorizontalAlignment(10);
        lastLogin.setText("Last login: ");
        userPanel.add(lastLogin, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createPortfolio = new JButton();
        createPortfolio.setText("New Portfolio");
        userPanel.add(createPortfolio, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
        goToLeaderboard = new JButton();
        goToLeaderboard.setText("Leaderboard");
        userPanel.add(goToLeaderboard, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        goToWatchList = new JButton();
        goToWatchList.setText("Watchlist");
        userPanel.add(goToWatchList, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), null, 0, false));
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
        return userPanel;
    }


}
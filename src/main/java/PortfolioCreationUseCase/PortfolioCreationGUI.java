package PortfolioCreationUseCase;

import javax.swing.*;

public class PortfolioCreationGUI extends JFrame implements iPortfolioCreationGUI{
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
}

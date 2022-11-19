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
    public void addPortfolioAction() {

    }

    @Override
    public void presentNameInvalidError() {

    }

    @Override
    public void presentDuplicateNameError() {

    }

    @Override
    public void close() {

    }
}

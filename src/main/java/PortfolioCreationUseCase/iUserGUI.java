package PortfolioCreationUseCase;

public interface iUserGUI {
    void addLogoutAction(Runnable onLogout);

    void addPortfolioSelectedAction(Runnable onPortfolioSelected);

    void createPortfolioAction(Runnable onCreatePortfolio);

    String getPortfolioSelected();

    void close();
}
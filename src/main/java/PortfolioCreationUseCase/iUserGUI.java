package PortfolioCreationUseCase;

public interface iUserGUI {
    void addLogoutAction(Runnable onLogout);

    void addPortfolioSelectedAction(Runnable onPortfolioSelected);

    String getPortfolioSelected();

    void close();
}
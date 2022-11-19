package PortfolioCreationUseCase;

public interface iPortfolioCreationGUI {
    String getNewPortfolioName();

    void addPortfolioAction();

    void presentNameInvalidError();

    void presentDuplicateNameError();

    void close();
}

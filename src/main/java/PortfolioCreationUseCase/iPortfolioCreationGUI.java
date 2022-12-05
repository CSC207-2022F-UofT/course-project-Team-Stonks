package PortfolioCreationUseCase;

/**
 * This is the interface for the portfolio creation use case
 */
public interface iPortfolioCreationGUI {
    String getNewPortfolioName();

    void addCreatePortfolioAction(Runnable onCreate);

    void addBackAction(Runnable onBack);

    void presentNameInvalidError();

    void presentDuplicateNameError();

    void close();
}

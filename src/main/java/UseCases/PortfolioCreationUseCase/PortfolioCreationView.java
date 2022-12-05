package UseCases.PortfolioCreationUseCase;

public interface PortfolioCreationView {
    String getNewPortfolioName();

    void addCreatePortfolioAction(Runnable onCreate);

    void addBackAction(Runnable onBack);

    void presentNameInvalidError();

    void presentDuplicateNameError();

    void close();
}
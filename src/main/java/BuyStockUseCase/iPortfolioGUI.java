package BuyStockUseCase;

public interface iPortfolioGUI {
    void addSearchAction(Runnable onLogin);

    void addBackAction(Runnable onLogin);
    void addMakeCompPortfolioAction(Runnable onMakeCompPortfolio);

    String getSearchField();
    void close();
    void removeCompPortfolioButton();

}
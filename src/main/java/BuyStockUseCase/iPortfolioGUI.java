package BuyStockUseCase;

public interface iPortfolioGUI {
    /**
     * Interface for the Portfolio GUI
     */
    void addSearchAction(Runnable onLogin);
    void addBackAction(Runnable onLogin);
    void addMakeCompPortfolioAction(Runnable onMakeCompPortfolio);
    String getSearchField();
    void close();
    void removeCompPortfolioButton();

}
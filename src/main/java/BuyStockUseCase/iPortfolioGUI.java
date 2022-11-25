package BuyStockUseCase;

public interface iPortfolioGUI {

    void addSearchAction(Runnable onLogin);

    void addBackAction(Runnable onLogin);

    String getSearchField();
    void close();
}
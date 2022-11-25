package BuyStockUseCase;

import entities.Portfolio;

public class PortfolioPresenter {
    private final iPortfolioGUI view;
    private final Portfolio portfolio;

    public PortfolioPresenter(iPortfolioGUI view, Portfolio portfolio) {
        this.view = view;
        this.portfolio = portfolio;
        this.view.addBackAction(this::onBack);
        this.view.addSearchAction(this::onSearch);
    }
    public void onBack() {
        view.close();
    }
    public void onSearch() {
        // TODO: CONNECT THE SEARCH FEATURE
        String symbol = view.getSearchField();

    }
}
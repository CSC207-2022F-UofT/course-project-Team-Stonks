package BuyStockUseCase;

import entities.Portfolio;

public class PortfolioPresenter {
    private final iPortfolioGUI view;
    private final Portfolio portfolio;

    public PortfolioPresenter(iPortfolioGUI view, Portfolio portfolio) {
        this.view = view;
        this.portfolio = portfolio;
    }
}
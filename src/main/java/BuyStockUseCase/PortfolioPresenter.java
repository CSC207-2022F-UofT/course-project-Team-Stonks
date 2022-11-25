package BuyStockUseCase;

import PortfolioCreationUseCase.PortfolioSelectedRequest;
import PortfolioCreationUseCase.UserPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;
import PortfolioCreationUseCase.PortfolioSelectedController;
import entities.User;
import java.util.ArrayList;

public class PortfolioPresenter {
    private final iPortfolioGUI view;
    private final Portfolio portfolio;
    private final User user;

    public PortfolioPresenter(iPortfolioGUI view, Portfolio portfolio, User user) {
        this.view = view;
        this.portfolio = portfolio;
        this.user = user;
    }
    public void addMakeCompPortfolioAction() {
        user.setCompPortfolio(portfolio.getName());
    }
}
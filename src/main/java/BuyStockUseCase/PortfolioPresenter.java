package BuyStockUseCase;

import PortfolioCreationUseCase.PortfolioSelectedRequest;
import PortfolioCreationUseCase.UserPresenter;
import PortfolioCreationUseCase.iUserGUI;
import entities.Portfolio;
import entities.User;
import PortfolioCreationUseCase.UserGUI;
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
        view.addBackAction(this::onBack);
        view.addMakeCompPortfolioAction(this::onMakeCompPortfolio);
    }
    public void onBack() {
        view.close();
        new UserPresenter(OuterLayerFactory.instance.getUserGUI(user.getUsername(),
                new ArrayList<>(user.getPortfolioNames()), user.getLastLogin()), user);

    }
    public void onSearch() {
        // TODO: CONNECT THE SEARCH FEATURE
        String symbol = view.getSearchField();

    }
    public void onMakeCompPortfolio() {
        user.setCompPortfolio(portfolio.getName());
        view.removeCompPortfolioButton();
    }
}
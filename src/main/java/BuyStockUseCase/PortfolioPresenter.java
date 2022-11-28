package BuyStockUseCase;

import PortfolioCreationUseCase.PortfolioSelectedRequest;
import PortfolioCreationUseCase.UserPresenter;
import PortfolioCreationUseCase.iUserGUI;
import SearchStockUseCase.ViewStockPresenter;
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
        view.addSearchAction(this::onSearch);
    }
    public void onBack() {
        view.close();
        new UserPresenter(OuterLayerFactory.instance.getUserGUI(user.getUsername(),
                new ArrayList<>(user.getPortfolioNames()), user.getLastLogin()), user);

    }
    public void onSearch() {
        String symbol = view.getSearchField();
        view.close();
        new ViewStockPresenter(OuterLayerFactory.instance.getViewStockGUI(symbol), this.portfolio);

    }
    public void onMakeCompPortfolio() {
        user.setCompPortfolio(portfolio.getName());
        view.removeCompPortfolioButton();
    }
}

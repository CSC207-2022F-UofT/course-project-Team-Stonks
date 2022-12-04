package BuyStockUseCase;


import PortfolioCreationUseCase.CompPortRequest;
import PortfolioCreationUseCase.PortfolioSelectedController;
import PortfolioCreationUseCase.UserPresenter;

import SearchStockUseCase.ViewStockController;
import SearchStockUseCase.ViewStockPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;


import java.util.ArrayList;

public class PortfolioPresenter {
    /**
     * Presenter for the portfolio GUI
     */
    private final iPortfolioGUI view;
    private final Portfolio portfolio;
    private final User user;
    private final PortfolioSelectedController psController;

    public PortfolioPresenter(iPortfolioGUI view, Portfolio portfolio, User user) {
        this.view = view;
        this.portfolio = portfolio;
        this.user = user;

        psController = new PortfolioSelectedController();

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
        try{
            new ViewStockController(symbol).stockIsValid();
        }catch (Exception e){
            this.view.invalidStockMessage(symbol);
            return;
        }
        view.close();
        new ViewStockPresenter(OuterLayerFactory.instance.getViewStockGUI(symbol, this.portfolio), this.portfolio, this.user);

    }
    public void onMakeCompPortfolio() {
        psController.NewCompPort(new CompPortRequest(user, portfolio.getName()));
        view.removeCompPortfolioButton();
    }
}
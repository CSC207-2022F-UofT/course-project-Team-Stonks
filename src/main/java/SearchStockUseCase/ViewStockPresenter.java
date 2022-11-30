package SearchStockUseCase;


import BuyStockUseCase.BuyStockPresenter;
import BuyStockUseCase.PortfolioPresenter;
import BuyStockUseCase.iPortfolioGUI;
import SellStockUseCase.SellStockPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;

import java.util.Map;

public class ViewStockPresenter {
    private final iViewStockGUI view;
    private final Portfolio portfolio;
    private final User user;
    private final ViewStockController controller;
    public ViewStockPresenter(iViewStockGUI view, Portfolio portfolio, User user){
        this.view = view;
        this.controller = new ViewStockController(this.view.getStockSymbol());
        this.portfolio = portfolio;
        this.user = user;
        view.addBuyStockAction(this::onBuyStock);
        view.addSellStockAction(this::onSellStock);
        view.addBackAction(this::onBack);

    }

    private void onBack() {
        boolean isComp = this.portfolio.getName().equals(user.getCompPortfolioName());
        view.close();
        new PortfolioPresenter(OuterLayerFactory.instance.getPortfolioGUI(this.portfolio, this.user.getUsername(), isComp),this.portfolio, this.user);
    }

    private void onSellStock() {
        //call Sell Presenter
        view.close();
        int quantity = portfolio.getStockQuantity(view.getStockSymbol());
        new SellStockPresenter(OuterLayerFactory.instance.getSellGUI(view.getStockSymbol(), quantity), this.portfolio, this.user);
    }

    public void onBuyStock(){
        //Call Buy Presenter
        view.close();
        int quantity = portfolio.getStockQuantity(view.getStockSymbol());
        new BuyStockPresenter(OuterLayerFactory.instance.getBuyGUI(view.getStockSymbol(), quantity), this.portfolio, this.user);
    }
}

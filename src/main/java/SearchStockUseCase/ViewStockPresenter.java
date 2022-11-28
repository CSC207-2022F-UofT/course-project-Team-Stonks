package SearchStockUseCase;


import BuyStockUseCase.BuyStockPresenter;
import BuyStockUseCase.PortfolioPresenter;
import BuyStockUseCase.iPortfolioGUI;
import SellStockUseCase.SellStockPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;

public class ViewStockPresenter {
    private final iViewStockGUI view;
    private final Portfolio portfolio;
    private final User user;
    public ViewStockPresenter(iViewStockGUI view, Portfolio portfolio, User user){
        this.view = view;
        boolean valid = new ViewStockUseCaseInteractor().searchStock(view.getStockSymbol());
        System.out.println(valid);
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
        new SellStockPresenter(OuterLayerFactory.instance.getSellGUI(view.getStockSymbol()), this.portfolio, this.user);
    }

    public void onBuyStock(){
        //Call Buy Presenter
        view.close();
        new BuyStockPresenter(OuterLayerFactory.instance.getBuyGUI(view.getStockSymbol()), this.portfolio, this.user);
    }
}

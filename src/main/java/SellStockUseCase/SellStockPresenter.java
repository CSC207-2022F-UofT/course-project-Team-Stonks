package SellStockUseCase;

import SearchStockUseCase.ViewStockPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;


public class SellStockPresenter {
    /**
     * This class is used to process the data from the model and display it to the user
     */
    private final iSellStockGUI view;
    private final Portfolio portfolio;
    private final SellStockController controller;
    private final User user;

    public SellStockPresenter(iSellStockGUI view, Portfolio portfolio, User user) {
        this.view = view;
        this.user = user;
        controller = new SellStockController();
        this.portfolio = portfolio;
        view.addSellAction(this::onSell);
        view.addGoBackAction(this::onBack);
    }
    private void onBack() {
        view.close();
        new ViewStockPresenter(OuterLayerFactory.instance.getViewStockGUI(view.getSymbol()), this.portfolio, this.user);
    }

    /**
     * This method is used to process the data given by the user and output the response to the user
     */
    private void onSell() {
        String symbol = view.getSymbol();
        int quantity = view.getQuantity();
        try {
            SellOutputResponse response = controller.sellStock(new SellInputRequest(portfolio, symbol, quantity));
            if (response.possible()) {
                view.displaySuccess();
                view.updateQuantityLabel(quantity);
            } else {
                view.displayQuantityFailure();
            }
        } catch (Exception e) {
            view.displayConnectionFailure();
        }
    }
}
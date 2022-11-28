package SellStockUseCase;

import SearchStockUseCase.ViewStockPresenter;
import entities.Portfolio;
import main.OuterLayerFactory;


public class SellStockPresenter {
    /**
     * This class is used to process the data from the model and display it to the user
     */
    private final iSellStockGUI view;
    private final Portfolio portfolio;
    private final SellStockController controller;

    public SellStockPresenter(iSellStockGUI view, Portfolio portfolio) {
        this.view = view;
        controller = new SellStockController();
        this.portfolio = portfolio;
        view.addSellAction(this::onSell);
        view.addGoBackAction(this::onBack);
    }
    private void onBack() {
        view.close();
        new ViewStockPresenter(OuterLayerFactory.instance.getViewStockGUI(view.getSymbol()), this.portfolio);
    }
    private void onSell() {
        String symbol = view.getSymbol();
        int quantity = view.getQuantity();
        try {
            SellOutputResponse response = controller.sellStock(new SellInputRequest(portfolio, symbol, quantity));
            if (response.possible()) {
                view.displaySuccess();
            } else {
                view.displayQuantityFailure();
            }
        } catch (Exception e) {
            view.displayConnectionFailure();
        }
    }
}

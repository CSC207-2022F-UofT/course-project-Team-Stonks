package BuyStockUseCase;

import entities.Portfolio;

import java.io.IOException;

public class BuyStockPresenter {
    private final iBuyStockGUI view;
    private final Portfolio currentPort;

    public BuyStockPresenter(iBuyStockGUI view, Portfolio currentPort){
        this.view = view;
        view.addBuyAction(this::onBuy);
        view.addGoBackAction(this::onBack);
        this.currentPort = currentPort;
    }

    private void onBuy() {
        String symbol = view.getSymbol();

        // Checks if user input is a positive integer; if not, prompts for a valid input
        int quantity;
        try {
            quantity = view.getQuantity();
        } catch (NumberFormatException e) {
            view.displayInvalidInputFailure();
            return;
        }

        if (quantity < 0) {
            view.displayInvalidInputFailure();
            return;
        }

        BuyInputRequest req = new BuyInputRequest(symbol, quantity, currentPort);

        // Tries to buy the stocks. If the portfolio has insufficient balance, displays price failure.
        BuyUseCaseInteractor interactor = new BuyUseCaseInteractor();
        BuyOutputResponse res;
        try {
            res = interactor.buyStock(req);
        } catch(IOException e) {
            view.displayConnectionFailure();
            return;
        }

        if (res.getOutput()) {
            view.displaySuccess();
        } else {
            view.displayBalanceFailure();
        }
    }

    private void onBack() {
        view.close();
    }
}

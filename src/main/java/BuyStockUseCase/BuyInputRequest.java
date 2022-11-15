package BuyStockUseCase;

import entities.Portfolio;

public class BuyInputRequest {

    /**
     * Request model class, carries user input to be passed to the BuyUseCaseInteractor.
     */

    String symbol;
    int buy_quantity;
    Portfolio port;

    public BuyInputRequest(String symbol, int buy_quantity, Portfolio port){
        this.symbol = symbol;
        this.buy_quantity = buy_quantity;
        this.port = port;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getQuantity() {
        return this.buy_quantity;
    }

    public Portfolio getPort() {
        return this.port;
    }
}

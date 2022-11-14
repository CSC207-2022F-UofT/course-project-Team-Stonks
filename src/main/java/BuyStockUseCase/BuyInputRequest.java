package BuyStockUseCase;

import entities.Portfolio;

public class BuyInputRequest {
    String symbol;
    int buy_quantity;
    Portfolio port;

    public BuyInputRequest(String symbol, int buy_quantity, Portfolio port){
        this.symbol = symbol;
        this.buy_quantity = buy_quantity;
        this.port = port;
    }
}

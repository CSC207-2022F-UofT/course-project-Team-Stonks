package db;

public class StockDSResponse {
    String symbol;
    double value;
    int quantity;

    public StockDSResponse (String symbol, double value, int quantity){
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getValue() {
        return this.value;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
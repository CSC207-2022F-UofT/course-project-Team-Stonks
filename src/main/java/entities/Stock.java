package entities;

public class Stock {
    private int id;
    private String symbol;
    private double value;

    public Stock(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol(){
        return symbol;
    }
}
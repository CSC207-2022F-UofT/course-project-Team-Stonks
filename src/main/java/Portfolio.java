import java.util.Map;

public class Portfolio {
    private double balance;
    public String id;
    public Map<Stock, Integer> stocks;

    public double getBalance() {
        return this.balance;
    }

    public void changeBalance(double amount){
        this.balance = this.balance + amount;
    }

    public void addStock(String symbol, int amount){
        // Adds Stocks to the stock map

    }
}

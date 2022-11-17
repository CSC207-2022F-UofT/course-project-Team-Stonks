package APIInterface;

public class StockAPIResponse {
    private double price;
    
    public StockAPIResponse(double price){
        this.price = price;
    }
    
    public double getPrice() {
        return this.price;
    }
}

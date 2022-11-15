package APIInterface;

public class StockAPIResponse {
    double price;
    public StockAPIResponse(double price){
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

}

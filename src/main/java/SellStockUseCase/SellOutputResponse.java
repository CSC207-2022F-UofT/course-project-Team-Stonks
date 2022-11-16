package SellStockUseCase;


public class SellOutputResponse {
    /**
     * This method is used to create a response object
     * @param message The message to be displayed to the user
     * @param totalValue The total value of the sale
     * @param quantity The quantity of stocks sold
     * @param symbol The symbol of the stock sold
     */
    private String message;
    private double totalValue;
    private int quantity;

    private String symbol;

    public SellOutputResponse(String message, double totalValue, int quantity, String symbol) {
        this.message = message;
        this.totalValue = totalValue;
        this.quantity = quantity;

        this.symbol = symbol;
    }

    public String getMessage() {
        return message;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSymbol() {
        return symbol;
    }
}

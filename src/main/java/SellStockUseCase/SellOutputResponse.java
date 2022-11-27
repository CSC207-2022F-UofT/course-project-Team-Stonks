package SellStockUseCase;


public class SellOutputResponse {

    /**
     * This method is used to create a response object
     * @param message The message to be displayed to the user
     * @param totalValue The total value of the sale
     * @param quantity The quantity of stocks sold
     * @param symbol The symbol of the stock sold
     */
    private final String message;
    private final double totalValue;
    private final int quantity;

    private final String symbol;
    private final boolean success;

    public SellOutputResponse(String message, double totalValue, int quantity, String symbol, boolean success) {
        this.message = message;
        this.totalValue = totalValue;
        this.quantity = quantity;
        this.symbol = symbol;
        this.success = success;
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
    public boolean possible() {
        return success;
    }
}

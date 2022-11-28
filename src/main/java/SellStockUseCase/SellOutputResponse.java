package SellStockUseCase;

public class SellOutputResponse {

    /**
     * This method is used to create a response object
     * @param message The message to be displayed to the user
     * @param totalValue The total value of the sale
     * @param quantity The quantity of stocks sold
     * @param symbol The symbol of the stock sold
     */
    private final boolean success;

    public SellOutputResponse(boolean success) {
        this.success = success;
    }

    public boolean possible() {
        return success;
    }
}
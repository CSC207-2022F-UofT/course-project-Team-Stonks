package SellStockUseCase;


public class SellOutputResponse {

    /**
     * This class is used to create responses for the sell stock use case
     */
    private final String message;

    private final int quantity;

    private final String symbol;

    private final boolean success;

    public SellOutputResponse(String message, int quantity, String symbol, boolean success) {
        this.message = message;

        this.quantity = quantity;
        this.symbol = symbol;
        this.success = success;
    }

    public String getMessage() {
        return message;
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

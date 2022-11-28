package SellStockUseCase;

public class SellOutputResponse {

    /**
     * This class is used to create responses for the sell stock use case
     */
    private final boolean success;

    public SellOutputResponse(boolean success) {
        this.success = success;
    }

    public boolean possible() {
        return success;
    }
}
package BuyStockUseCase;

public class BuyOutputResponse {

    /**
     * Response model class, carries output from BuyUseCaseInteractor to be displayed to the user.
     */

    private final boolean output;

    public BuyOutputResponse(boolean output){
        this.output = output;
    }

    public boolean getOutput() {
        return this.output;
    }
}


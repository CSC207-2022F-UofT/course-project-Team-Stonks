package BuyStockUseCase;

public class BuyOutputResponse {

    /**
     * Response model class, carries output from BuyUseCaseInteractor to be displayed to the user.
     */

    private final boolean output;

    public BuyOutputResponse(boolean output_text){
        this.output = output_text;
    }

    public boolean getOutput() {
        return this.output;
    }
}
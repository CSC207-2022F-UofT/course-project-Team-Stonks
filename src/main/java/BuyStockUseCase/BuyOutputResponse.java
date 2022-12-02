package BuyStockUseCase;

public class BuyOutputResponse {

    /**
     * Response model class, carries output from BuyUseCaseInteractor to be displayed to the user.
     *  output == true if purchase is successful
     *  output == false if purchase fails due to insufficient balance
     *  output == null if there's a connection problem with the API
     */

    private final Boolean output;

    public BuyOutputResponse(Boolean output){
        this.output = output;
    }

    public Boolean getOutput() {
        return this.output;
    }
}
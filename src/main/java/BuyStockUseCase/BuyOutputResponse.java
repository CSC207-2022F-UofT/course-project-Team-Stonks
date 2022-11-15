package BuyStockUseCase;

public class BuyOutputResponse {

    /**
     * Response model class, carries output string from BuyUseCaseInteractor to be displayed to the user.
     */

    String output_text;

    public BuyOutputResponse(String output_text){
        this.output_text = output_text;
    }

    public String getOutput() {
        return this.output_text;
    }
}


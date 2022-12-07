package UseCases.BuyStockUseCase;

/**
 * @param output Response model class, carries output from BuyUseCaseInteractor to be displayed to the user.
 *               output == true if purchase is successful
 *               output == false if purchase fails due to insufficient balance
 *               output == null if there's a connection problem with the API
 */
public record BuyOutputResponse(Boolean output) {

}
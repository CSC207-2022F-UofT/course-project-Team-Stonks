package UseCases.PortfolioCreationUseCase;

/**
 * Response model object for when user attempts to log in, contains PortfolioCreationError which indicates whether
 * a portfolio has been created or an error occurred.
 */
public record PortfolioCreationResponse(PortfolioCreationError portfolioCreated) {
}
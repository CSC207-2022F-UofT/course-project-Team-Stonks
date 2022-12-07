package UseCases.PortfolioCreationUseCase;

/**
 * Request model object for when user attempts to make a new portfolio, contains only a string portfolioName
 */
public record PortfolioCreationRequest(String portfolioName) {
}
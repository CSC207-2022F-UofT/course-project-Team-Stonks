package UseCases.PortfolioCreationUseCase;

public final class PortfolioCreationResponse {
    private final PortfolioCreationError portfolioCreated;

    public PortfolioCreationResponse(PortfolioCreationError portfolioCreated) {
        this.portfolioCreated = portfolioCreated;
    }

    public PortfolioCreationError portfolioCreated() {
        return portfolioCreated;
    }
}
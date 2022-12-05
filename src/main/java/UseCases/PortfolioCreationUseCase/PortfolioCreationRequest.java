package UseCases.PortfolioCreationUseCase;

public final class PortfolioCreationRequest {
    private final String portfolioName;

    public PortfolioCreationRequest(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String portfolioName() {
        return portfolioName;
    }
}
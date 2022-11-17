package PortfolioCreationUseCase;

public class PortfolioCreationController {
    private PortfolioCreationInteractor pInteractor;

    public PortfolioCreationController() {
        pInteractor = new PortfolioCreationInteractor();
    }

    public PortfolioCreationResponse createPortfolio(PortfolioCreationRequest request) {
        return new PortfolioCreationResponse();
    }
}
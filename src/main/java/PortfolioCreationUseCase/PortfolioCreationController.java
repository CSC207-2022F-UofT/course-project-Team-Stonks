package PortfolioCreationUseCase;

import RegisterUseCase.RegisterError;

public class PortfolioCreationController {
    private PortfolioCreationInteractor pInteractor;

    public PortfolioCreationController() {
        pInteractor = new PortfolioCreationInteractor();
    }

    public PortfolioCreationResponse createPortfolio(PortfolioCreationRequest request) {
        PortfolioCreationError portfolioCreated = pInteractor.makeNewPortfolio(request.portfolioName());

        return new PortfolioCreationResponse(portfolioCreated);
    }
}
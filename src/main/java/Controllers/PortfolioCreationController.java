package Controllers;

import UseCases.PortfolioCreationUseCase.PortfolioCreationError;
import UseCases.PortfolioCreationUseCase.PortfolioCreationInteractor;
import UseCases.PortfolioCreationUseCase.PortfolioCreationRequest;
import UseCases.PortfolioCreationUseCase.PortfolioCreationResponse;
import entities.User;

public class PortfolioCreationController {
    private final PortfolioCreationInteractor pInteractor;

    public PortfolioCreationController(User user) {
        pInteractor = new PortfolioCreationInteractor(user);
    }

    public PortfolioCreationResponse createPortfolio(PortfolioCreationRequest request) {
        PortfolioCreationError portfolioCreated = pInteractor.makeNewPortfolio(request.portfolioName());

        return new PortfolioCreationResponse(portfolioCreated);
    }
}
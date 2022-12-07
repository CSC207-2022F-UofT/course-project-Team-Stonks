package Controllers;

import UseCases.PortfolioCreationUseCase.CompPortRequest;
import UseCases.PortfolioCreationUseCase.PortfolioSelectedInteractor;
import UseCases.PortfolioCreationUseCase.PortfolioSelectedRequest;

public class PortfolioSelectedController {
    private final PortfolioSelectedInteractor interactor;

    public PortfolioSelectedController() {
        interactor = new PortfolioSelectedInteractor();
    }
    public void PopulatePortfolio(PortfolioSelectedRequest request) {
        interactor.populatePortfolio(request.user(), request.portfolioName());
    }

    public void NewCompPort(CompPortRequest request) {
        interactor.MakeCompPort(request.user(), request.compPort());
    }
}
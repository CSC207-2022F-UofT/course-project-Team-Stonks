package PortfolioCreationUseCase;

import entities.Portfolio;

public class PortfolioSelectedController {
    private final PortfolioSelectedInteractor interactor;

    public PortfolioSelectedController() {
        interactor = new PortfolioSelectedInteractor();
    }
    public void PopulatePortfolio(PortfolioSelectedRequest request) {
        interactor.populatePortfolio(request.getUser(), request.getPortfolioName());
    }
    public void makeCompPortfolio(PortfolioSelectedRequest request) {
        interactor.makeCompPortfolio(request.getUser(), request.getPortfolioName());
    }
}
package PortfolioCreationUseCase;

public class PortfolioCreationController {
    private final PortfolioCreationInteractor interactor;

    public PortfolioCreationController() {
        interactor = new PortfolioCreationInteractor();
    }
    public void PopulatePortfolio(PortfolioCreationRequest request) {
        interactor.populatePortfolio(request.getUser(), request.getPortfolioName());
    }
}
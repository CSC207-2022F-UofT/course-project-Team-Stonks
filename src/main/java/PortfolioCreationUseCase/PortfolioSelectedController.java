package PortfolioCreationUseCase;

public class PortfolioSelectedController {
    private final PortfolioSelectedInteractor interactor;

    public PortfolioSelectedController() {
        interactor = new PortfolioSelectedInteractor();
    }
    public void PopulatePortfolio(PortfolioSelectedRequest request) {
        interactor.populatePortfolio(request.getUser(), request.getPortfolioName());
    }

    public void NewCompPort(CompPortRequest request) {
        interactor.MakeCompPort(request.getUser(), request.getCompPort());
    }
}
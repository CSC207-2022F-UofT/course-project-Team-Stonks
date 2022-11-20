package PortfolioCreationUseCase;

import entities.User;

public class PortfolioCreationPresenter {
    private final iPortfolioCreationGUI view;
    private final iUserGUI upper;
    private final PortfolioCreationController controller;
    private final User user;

    public PortfolioCreationPresenter(iPortfolioCreationGUI view, iUserGUI upper, User user) {
        this.view = view;
        this.upper = upper;
        this.user = user;
        controller = new PortfolioCreationController(user);

        view.addCreatePortfolioAction(this::createPortfolio);
        view.addBackAction(this::onBack);
    }

    private void createPortfolio(){
        PortfolioCreationRequest request = new PortfolioCreationRequest(view.getNewPortfolioName());

        PortfolioCreationResponse response = controller.createPortfolio(request);

        switch (response.portfolioCreated()){
            case DUPLICATE_NAME -> view.presentDuplicateNameError();
            case INVALID_NAME -> view.presentNameInvalidError();
            default -> onBack();
        }
    }

    private void onBack(){
        view.close();
        new UserPresenter(upper, user);
    }
}
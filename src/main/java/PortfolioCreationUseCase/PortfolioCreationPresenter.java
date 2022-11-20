package PortfolioCreationUseCase;

import entities.User;

public class PortfolioCreationPresenter {
    private iPortfolioCreationGUI view;
    private iUserGUI upper;
    private PortfolioCreationController controller;
    private User user;

    public PortfolioCreationPresenter(iPortfolioCreationGUI view, iUserGUI upper, User user) {
        this.view = view;
        this.upper = upper;
        this.user = user;
        controller = new PortfolioCreationController(user);

    }

    private void onBack(){
        view.close();
        new UserPresenter(upper, user);
    }
}

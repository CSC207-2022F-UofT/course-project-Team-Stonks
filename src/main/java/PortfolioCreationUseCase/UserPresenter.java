package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.User;
import main.OuterLayerFactory;

public class UserPresenter {
    private final iUserGUI view;
    private final PortfolioSelectedController controller;
    private final User user;


    public UserPresenter(iUserGUI view, User user) {
        this.view = view;

        this.user = user;
        controller = new PortfolioSelectedController();


        view.addLogoutAction(this::onLogout);
        view.addPortfolioSelectedAction(this::onPortfolioSelected);
        view.createPortfolioAction(this::onCreatePortfolio);
    }

    private void onLogout() {
        view.close();
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());
    }

    private void onPortfolioSelected() {
        String portfolioName = view.getPortfolioSelected();

        controller.PopulatePortfolio(new PortfolioSelectedRequest(user, portfolioName));

        view.close();
        new PortfolioPresenter(
                OuterLayerFactory.instance.getPortfolioGUI(
                        user.getCurPortfolio(), user.getUsername()),
                user.getPortfolio(portfolioName));
    }

    private void onCreatePortfolio() {
        view.close();
        new PortfolioCreationPresenter(OuterLayerFactory.instance.getPortfolioCreationGUI(), user);
    }
}
package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.User;
import main.OuterLayerFactory;

public class PortfolioCreationPresenter {
    private final iUserGUI view;
    private final PortfolioCreationController controller;
    private final User user;


    public PortfolioCreationPresenter(iUserGUI view, User user) {
        this.view = view;
        this.user = user;
        controller = new PortfolioCreationController();


        view.addLogoutAction(this::onLogout);
        view.addPortfolioSelectedAction(this::onPortfolioSelected);
    }

    private void onLogout() {
        view.close();
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());
    }

    private void onPortfolioSelected() {
        String portfolioName = view.getPortfolioSelected();

        //Add call to controller to add the stocks of selected portfolio to user

        view.close();
        new PortfolioPresenter(OuterLayerFactory.instance.getPortfolioGUI(
                portfolioName,
                user.getPortfolio(portfolioName).getBalance(), user.getUsername()));
    }

    private void onCreatePortfolio() {
        //TODO
    }
}
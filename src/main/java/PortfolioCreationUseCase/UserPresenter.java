package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.User;
import main.OuterLayerFactory;

public class UserPresenter {
    private iUserGUI view;
    private PortfolioCreationController controller;
    private User user;


    public UserPresenter(iUserGUI view, User user) {
        this.view = view;

        this.user = user;
        controller = new PortfolioCreationController(user);


        view.addLogoutAction(() -> onLogout());
        view.addPortfolioSelectedAction(() -> onPortfolioSelected());
        view.createPortfolioAction(() -> onCreatePortfolio());
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
        view.close();
        new PortfolioCreationPresenter(OuterLayerFactory.instance.getPortfolioCreationGUI(), view, user);
    }
}
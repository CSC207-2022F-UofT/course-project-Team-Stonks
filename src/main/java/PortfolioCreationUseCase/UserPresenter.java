package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.Portfolio;
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
    }

    private void onLogout() {
        view.close();
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());
    }

    private void onPortfolioSelected() {
        Portfolio portfolio = user.getPortfolio(view.getPortfolioSelected());
        PortfolioSelectedRequest request = new PortfolioSelectedRequest(user, portfolio.getName());
        controller.PopulatePortfolio(request);

        view.close();
        new PortfolioPresenter(
                OuterLayerFactory.instance.getPortfolioGUI(
                        portfolio.getName(),
                        portfolio.getBalance(),
                        user.getUsername()),
                portfolio
                );
    }

    private void onCreatePortfolio() {
        //TODO
    }
}
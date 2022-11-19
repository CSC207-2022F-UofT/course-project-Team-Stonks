package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.Portfolio;
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
        Portfolio portfolio = user.getPortfolio(view.getPortfolioSelected());
        PortfolioCreationRequest request = new PortfolioCreationRequest(user, portfolio.getName());
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
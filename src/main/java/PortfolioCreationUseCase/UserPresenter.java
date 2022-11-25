package PortfolioCreationUseCase;

import BuyStockUseCase.PortfolioPresenter;
import LoginUseCase.UserLoginPresenter;
import entities.User;
import main.OuterLayerFactory;
import LeaderboardUseCase.LeaderboardPresenter;
import LeaderboardUseCase.LeaderboardController;

public class UserPresenter {
    private final iUserGUI view;
    private final PortfolioSelectedController controller;
    private final User user;
    private final LeaderboardController lController;


    public UserPresenter(iUserGUI view, User user) {
        this.view = view;

        this.user = user;
        controller = new PortfolioSelectedController();
        lController = new LeaderboardController();

        view.addLogoutAction(this::onLogout);
        view.addPortfolioSelectedAction(this::onPortfolioSelected);
        view.createPortfolioAction(this::onCreatePortfolio);
        view.goToLeaderboardAction(this::onGoToLeaderboard);
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
                        portfolioName,
                        user.getPortfolio(portfolioName).getBalance(), user.getUsername()),
                user.getPortfolio(portfolioName), user);
    }

    private void onCreatePortfolio() {
        view.close();
        new PortfolioCreationPresenter(OuterLayerFactory.instance.getPortfolioCreationGUI(), user);
    }
    private void onGoToLeaderboard() {
        view.close();
        new LeaderboardPresenter(OuterLayerFactory.instance.getLeaderboardGUI(), user);
    }
}
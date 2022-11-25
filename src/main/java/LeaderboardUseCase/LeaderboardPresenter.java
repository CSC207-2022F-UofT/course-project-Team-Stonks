package LeaderboardUseCase;
import PortfolioCreationUseCase.UserPresenter;
import entities.User;
import main.OuterLayerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class LeaderboardPresenter {
    private final iLeaderboardGUI view;
    private final LeaderboardController controller;
    private final User user;

    public LeaderboardPresenter(iLeaderboardGUI view, User user) {
        this.view = view;
        this.user = user;
        this.controller = new LeaderboardController();
        view.addBackAction(this::onBackAction);
    }
    public void onViewBoard() {
        LeaderboardResponse response = controller.currLeaderboard();
    }
    public void onBackAction() {
        view.close();
        new UserPresenter(OuterLayerFactory.instance.getUserGUI(user.getUsername(), new ArrayList<>(user.getPortfolioNames()), user.getLastLogin()), user);
    }
}


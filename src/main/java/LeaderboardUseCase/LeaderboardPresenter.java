package LeaderboardUseCase;
import entities.Portfolio;

import javax.sound.sampled.Port;


public class LeaderboardPresenter {
    private Portfolio portfolio;
    private LeaderboardController controller;

    public LeaderboardPresenter(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.controller = new LeaderboardController();
    }
    public void onLogin() {

    }
}

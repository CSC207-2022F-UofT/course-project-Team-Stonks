package LeaderboardUseCase;

import entities.Leaderboard;

public class LeaderboardController {
    private iLeaderboardInputBoundary interactor;

    /**
     * Creates a new instance of LeaderboardController with an instance of the LeaderboardUseCaseInteractor
     */
    public LeaderboardController() {
        interactor = new LeaderboardUseCaseInteractor();
    }

    /**
     * @return a LeaderboardResponse object generated from interactor.updateLeaderboard()
     */
    public LeaderboardResponse currLeaderboard() {
        return new LeaderboardResponse(interactor.updateLeaderboard());
    }
}

package LeaderboardUseCase;

public class LeaderboardController {
    private LeaderboardUseCaseInteractor interactor;
    public LeaderboardController() {
        interactor = new LeaderboardUseCaseInteractor();
    }
    public LeaderboardResponse currLeaderboard() {
        return new LeaderboardResponse(interactor.updateLeaderboard());
    }
}

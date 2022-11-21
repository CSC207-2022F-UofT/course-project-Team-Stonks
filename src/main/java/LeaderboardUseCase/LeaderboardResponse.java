package LeaderboardUseCase;

import entities.Leaderboard;

public class LeaderboardResponse {
    private final Leaderboard output;

    public LeaderboardResponse(Leaderboard output) {
        this.output = output;
    }
    public Leaderboard getLeaderboardOutput() {
        return output;
    }
}

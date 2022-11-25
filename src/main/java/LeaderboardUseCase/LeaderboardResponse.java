package LeaderboardUseCase;

import entities.Leaderboard;
import entities.User;
import LeaderboardUseCase.LeaderboardUseCaseInteractor;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardResponse {
    private final Leaderboard board;
    public LeaderboardResponse(Leaderboard board) {
        this.board = board;
    }
    public List<String> toStringList() {
        List<String> result = new ArrayList<String>();
        int position = 1;
        LeaderboardUseCaseInteractor interactor = new LeaderboardUseCaseInteractor();
        double[] topValues = interactor.topValues();
        for(User u : board.getTopUsers()) {

            result.add(position + ". " + u.getUsername() + ":             $"+topValues[position-1]);
            position++;
        }
        return result;
    }
}

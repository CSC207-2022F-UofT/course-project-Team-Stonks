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

    /**
     * @return a representation of the LeaderboardResponse in the form of a List of Strings, with the Strings
     * representing the names of the top users, in order of position on the board
     */
    public List<String> toStringList() {
        List<String> result = new ArrayList<String>();
        int position = 1;
        LeaderboardUseCaseInteractor interactor = new LeaderboardUseCaseInteractor();
        double[] topValues = interactor.topValues();
        for(User u : board.getTopUsers()) {

            result.add(position + ". " + u.getUsername() + ":" + " " + new String(new char[(100-u.getUsername().length())]).replace("\0", "-") + "$"+topValues[position-1]);
            position++;
        }
        return result;
    }
}

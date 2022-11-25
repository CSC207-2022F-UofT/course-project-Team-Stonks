package LeaderboardUseCase;

import java.util.List;
import java.util.ArrayList;
import entities.Leaderboard;
import entities.UserManager;
import entities.User;
import entities.Portfolio;

public class LeaderboardUseCaseInteractor {

    public LeaderboardUseCaseInteractor() {}
    public int indexMax(double[] arr) {
        double maxNum = -1;
        int result = -1;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] > maxNum) {
                result = i;
                maxNum = arr[i];
            }
        }
        return result;
    }

    public Leaderboard updateLeaderboard() {
        ArrayList<User> listOfUsers = (ArrayList<User>) UserManager.instance.getAllUsers();
        double[] listOfVals =  new double[listOfUsers.size()];
        int i = 0;
        for(User u : listOfUsers) {
            Portfolio compPortfolio = u.getCompPortfolio();
            listOfVals[i] = compPortfolio.getNetValue();
            i++;
        }
        ArrayList<User> resultList = new ArrayList<User>();
        for(int j = 0; j < Leaderboard.SIZE; j++) {
            int indexOfMax = indexMax(listOfVals);
            resultList.add(listOfUsers.get(indexOfMax));
            listOfVals[indexOfMax] = -1;
        }
        return new Leaderboard(resultList);
    }
}

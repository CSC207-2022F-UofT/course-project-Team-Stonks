package LeaderboardUseCase;

import java.sql.Date;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import entities.Leaderboard;
import entities.UserManager;
import entities.User;
import entities.Portfolio;

public class LeaderboardUseCaseInteractor {

    public LeaderboardUseCaseInteractor() {}

    /**
     * @param arr an array of doubles
     * @return the index of the maximum value in the array
     */
    public int indexMax(double[] arr) {
        double maxNum = -2;
        int result = -3;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] > maxNum) {
                result = i;
                maxNum = arr[i];
            }
        }
        return result;
    }

    /**
     * @param arr an array of doubles
     * @return the maximum value of the doubles in arr
     */
    public double max(double[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        double maxNum = arr[0];
        for(double num : arr) {
            if(num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    /**
     * @return an array of doubles, with the doubles representing the values of each of the users' competitive
     * portfolio values. The order of the array corresponds to the order of the listOfUsers from the getAllUsers call
     */
    public double[] topValues() {
        List<User> listOfUsers = UserManager.instance.getAllUsers();
        double[] listOfVals =  new double[listOfUsers.size()];
        int i = 0;
        for(User u : listOfUsers) {
            if(u.getCompPortfolio() == null) {
                listOfVals[i] = 0;
            } else {
                listOfVals[i] = u.getCompPortfolio().getNetValue();
            }
            i++;
        }
        return listOfVals;
    }

    /**
     * @return a Leaderboard object with the top users according to the current value of their competitive portfolios
     */
    public Leaderboard updateLeaderboard() {
        double[] listOfVals = topValues();
        List<User> listOfUsers = UserManager.instance.getAllUsers();
        List<User> resultList = new ArrayList<User>();
        for(int j = 0; j < Leaderboard.SIZE; j++) {
            int indexOfMax = indexMax(listOfVals);
            resultList.add(listOfUsers.get(indexOfMax));
            listOfVals[indexOfMax] = -5;
        }
        return new Leaderboard(resultList);
    }
}

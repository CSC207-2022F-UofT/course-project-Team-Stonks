package LeaderboardUseCase;

import entities.Leaderboard;
import entities.User;
import entities.UserManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeaderboardUseCaseInteractor implements iLeaderboardInputBoundary {
    private List<User> users;

    /**
     * @param arr an array of doubles
     * @return the index of the maximum value in the array
     */
    private int indexMax(double[] arr) {
        double maxNum = -1;
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                result = i;
                maxNum = arr[i];
            }
        }
        return result;
    }

    /**
     * @return an array of doubles, with the doubles representing the values of each of the users' competitive
     * portfolio values. The order of the array corresponds to the order of the listOfUsers from the getAllUsers call
     */
    private double[] topValues() {
        users = UserManager.instance.getAllUsers();
        double[] listOfVals = new double[users.size()];
        int i = 0;

        for (User u : users) {
            if (u.getCompPortfolio() != null) {
                listOfVals[i] = u.getCompPortfolio().getNetValue();
            } else {
                listOfVals[i] = 0;
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
        Map<User, Double> result = new LinkedHashMap<>();

        for (int j = 0; j < Math.min(Leaderboard.SIZE, listOfVals.length); j++) {
            int indexOfMax = indexMax(listOfVals);
            result.put(users.get(indexOfMax), listOfVals[indexOfMax]);
            listOfVals[indexOfMax] = -1;
        }
        return new Leaderboard(result);
    }
}

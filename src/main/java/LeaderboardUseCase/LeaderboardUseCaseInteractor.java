package LeaderboardUseCase;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import entities.Leaderboard;
import entities.UserManager;
import entities.User;
import entities.Portfolio;

public class LeaderboardUseCaseInteractor {

    public LeaderboardUseCaseInteractor() {}
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
    public double[] topValues() {
        List<User> listOfUsers = UserManager.instance.getAllUsers();
        double[] listOfVals =  new double[listOfUsers.size()];
        int i = 0;
        for(User u : listOfUsers) {
            ArrayList<String> portfolioNameList = new ArrayList<>(u.getPortfolioNames());
            double[] portfolioValues = new double[u.getPortfolioNames().size()];
            int j = 0;
            for(String pName : portfolioNameList) {
                portfolioValues[j] = u.getPortfolio(pName).getNetValue();
                j += 1;
            }
            listOfVals[i] = max(portfolioValues);
            i++;
        }
        return listOfVals;
    }

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

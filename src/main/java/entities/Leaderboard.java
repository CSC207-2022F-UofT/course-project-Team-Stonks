package entities;

import java.util.Map;

public class Leaderboard {

    public static int SIZE = 5;
    private final Map<User, Double> topUsers;

    /**
     * @param topUsers the Map representation of the Leaderboard, with keys representing Users and values representing
     *                 net values of competitive portfolio
     */
    public Leaderboard(Map<User, Double> topUsers) {
        this.topUsers = topUsers;
    }

    /**
     * @return the topUsers attribute from a leaderboard
     */
    public Map<User, Double> getTopUsers() {
        return this.topUsers;
    }
}
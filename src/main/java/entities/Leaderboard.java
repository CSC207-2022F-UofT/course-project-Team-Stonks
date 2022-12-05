package entities;

import java.util.Map;

public class Leaderboard {

    public static final int SIZE = 5;
    private final Map<User, Double> topUsers;

    /**
     * @param topUsers the List representation of the Leaderboard, with the order of users in the List representing
     *                 the positions in the leaderboard
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
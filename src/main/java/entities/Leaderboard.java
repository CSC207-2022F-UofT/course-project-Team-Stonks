package entities;

import java.util.Map;

public record Leaderboard(Map<User, Double> topUsers) {

    public static final int SIZE = 5;

    /**
     * @param topUsers the Map representation of the Leaderboard, with keys representing Users and values representing
     *                 net values of competitive portfolio
     */
    public Leaderboard {
    }

    /**
     * @return the topUsers attribute from a leaderboard
     */
    @Override
    public Map<User, Double> topUsers() {
        return this.topUsers;
    }
}
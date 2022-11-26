package entities;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private List<User> topUsers;
    public static final int SIZE = 5;

    /**
     * @param topUsers the List representation of the Leaderboard, with the order of users in the List representing
     *                 the positions in the leaderboard
     */
    public Leaderboard(List<User> topUsers) {
        this.topUsers = topUsers;
    }

    /**
     * @return the topUsers attribute from a leaderboard
     */
    public List<User> getTopUsers() {
        return this.topUsers;
    }
}

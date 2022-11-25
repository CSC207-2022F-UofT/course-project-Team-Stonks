package entities;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private List<User> topUsers;
    public static final int SIZE = 5;

    public Leaderboard(List<User> topUsers) {
        this.topUsers = topUsers;
    }
    public List<User> getTopUsers() {
        return this.topUsers;
    }
}

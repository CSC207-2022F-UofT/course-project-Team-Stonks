package LeaderboardTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import LeaderboardUseCase.LeaderboardUseCaseInteractor;
import entities.UserManager;
import entities.User;
import java.util.List;

public class LeaderboardTest {
    private static LeaderboardUseCaseInteractor interactor;


    @BeforeAll
    public static void setUp() {
        interactor = new LeaderboardUseCaseInteractor();
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = UserManager.instance.getAllUsers();
        Assertions.assertFalse(users.isEmpty());
    }
}
package LeaderboardTest;

import RegisterUseCase.RegisterController;
import db.PortfolioDSRequest;
import db.iEntityDBGateway;
import main.OuterLayerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import LeaderboardUseCase.LeaderboardUseCaseInteractor;
import entities.UserManager;
import entities.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import entities.Portfolio;
import db.UserDSRequest;
import entities.Leaderboard;

public class LeaderboardTest {
    private static LeaderboardUseCaseInteractor interactor;
    private static final String correctUsername = "database";
    private static final String correctPassword = "password";
    private static final String correctPasswordConfirm = "password";
    private static iEntityDBGateway dbGateway;



    @BeforeAll
    public static void setUp() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();

        dbGateway.deleteUser("testUser1");
        dbGateway.deleteUser("testUser2");

        interactor = new LeaderboardUseCaseInteractor();
        UserDSRequest testUser1 = new UserDSRequest("testUser1", "password", Date.valueOf(LocalDate.now()));
        dbGateway.addUser(testUser1);
        UserDSRequest testUser2 = new UserDSRequest("testUser2", "password", Date.valueOf(LocalDate.now()));
        dbGateway.addUser(testUser2);
        PortfolioDSRequest portfolio1 = new PortfolioDSRequest("Portfolio1", 100001, "testUser1");
        PortfolioDSRequest portfolio2 = new PortfolioDSRequest("Portfolio2", 100000, "testUser2");
        dbGateway.addPortfolio(portfolio1);
        dbGateway.addPortfolio(portfolio2);
    }

    @Test
    public void testGetAllUsersNonEmpty() {
        List<User> users = UserManager.instance.getAllUsers();
        Assertions.assertFalse(users.isEmpty());
    }
    @Test
    public void testLeaderboardTwoUsers() {
        Leaderboard newBoard = interactor.updateLeaderboard();

    }
}
package UserLoginPresenterTest;

import LoginUseCase.UserLoginController;
import LoginUseCase.UserLoginRequest;
import LoginUseCase.UserLoginResponse;
import db.UserDSRequest;
import db.iEntityDBGateway;
import entities.EntityHolder;
import entities.User;
import entities.UserManager;
import main.OuterLayerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class UserLoginPresenterTest {
    private static UserLoginController controller;
    private static UserManager userManager;
    private static final String correctUsername = "database";
    private static final String correctPassword = "password";

    @BeforeAll
    public static void setUp() {
        controller = new UserLoginController();
        userManager = EntityHolder.instance.getUserManager();
        iEntityDBGateway dbGateway = OuterLayerFactory.instance.getEntityDSGateway();

        if (!userManager.userExists(correctUsername)) {
            dbGateway.addUser(new UserDSRequest(correctUsername, correctPassword, Date.valueOf(LocalDate.now())));
        }
    }

    @Test
    public void testLoginFalseUsername() {
        UserLoginRequest request = new UserLoginRequest(
                "userDoesn'tExist",
                "password",
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        Assertions.assertNull(response.user());
    }

    @Test
    public void testLoginFalsePassword() {
        UserLoginRequest request = new UserLoginRequest(
                "username",
                "wrongPassword",
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        Assertions.assertNull(response.user());
    }

    @Test
    public void testLoginUserExists() {
        UserLoginRequest request = new UserLoginRequest(
                correctUsername,
                correctPassword,
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        User user = response.user();
        Assertions.assertEquals(user.getUsername(), correctUsername);
        Assertions.assertTrue(user.isPassword(correctPassword));
    }
}
package login_user_use_case_test;

import LoginUseCase.UserLoginController;
import LoginUseCase.UserLoginRequest;
import LoginUseCase.UserLoginResponse;
import db.UserDSRequest;
import db.iEntityDBGateway;
import entities.EntityHolder;
import entities.User;
import entities.UserManager;
import main.OuterLayerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class UserLoginPresenterTest {
    private UserLoginController controller;
    private UserManager userManager;
    private iEntityDBGateway dbGateway;
    private final String correctUsernameInSystem = "system";
    private final String correctPassword = "password";


    @BeforeEach
    void setUp() {
        controller = new UserLoginController();
        userManager = EntityHolder.instance.getUserManager();
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();

        if (!userManager.userExists(correctUsernameInSystem)) {
            userManager.createUser(correctUsernameInSystem, correctPassword, Date.valueOf(LocalDate.now()));
        }

        String correctUsernameInDB = "database";
        if (!userManager.userExists(correctUsernameInDB)) {
            dbGateway.addUser(new UserDSRequest(correctUsernameInDB, correctPassword, Date.valueOf(LocalDate.now())));
        }
    }

    @Test
    void testLoginFalseUsername() {
        UserLoginRequest request = new UserLoginRequest(
                "userDoesn'tExist",
                "password",
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        Assertions.assertNull(response.user());
    }

    @Test
    void testLoginFalsePassword() {
        UserLoginRequest request = new UserLoginRequest(
                "username",
                "wrongPassword",
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        Assertions.assertNull(response.user());
    }

    @Test
    void testLoginUserExistsInSystem() {
        UserLoginRequest request = new UserLoginRequest(
                correctUsernameInSystem,
                correctPassword,
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        User user = response.user();
        Assertions.assertEquals(user.getUsername(), correctUsernameInSystem);
        Assertions.assertTrue(user.isPassword(correctPassword));
    }

    @AfterEach
    void tearDown() {
    }
}
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
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class UserLoginPresenterTest {
    private UserLoginController controller;
    private UserManager userManager;
    private final String correctUsername = "database";
    private final String correctPassword = "password";

    @Before
    public void setUp() {
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
        Assert.assertNull(response.user());
    }

    @Test
    public void testLoginFalsePassword() {
        UserLoginRequest request = new UserLoginRequest(
                "username",
                "wrongPassword",
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        Assert.assertNull(response.user());
    }

    @Test
    public void testLoginUserExists() {
        UserLoginRequest request = new UserLoginRequest(
                correctUsername,
                correctPassword,
                Date.valueOf(LocalDate.now()));

        UserLoginResponse response = controller.loginUser(request);
        User user = response.user();
        Assert.assertEquals(user.getUsername(), correctUsername);
        Assert.assertTrue(user.isPassword(correctPassword));
    }

    @After
    public void tearDown() {
    }
}
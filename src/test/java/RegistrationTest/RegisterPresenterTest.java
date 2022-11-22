package RegistrationTest;

import LoginUseCase.UserLoginController;
import LoginUseCase.UserLoginRequest;
import LoginUseCase.UserLoginResponse;
import RegisterUseCase.*;
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

import static org.junit.jupiter.api.Assertions.*;

class RegisterPresenterTest {

    private static RegisterController controller;
    private static RegisterPresenter presenter;
    private static UserManager userManager;
    private static final String correctUsername = "database";
    private static final String correctPassword = "password";
    private static final String correctPasswordConfirm = "password";

    @BeforeAll
    public static void setUp() {
        controller = new RegisterController();
        userManager = EntityHolder.instance.getUserManager();
        iEntityDBGateway dbGateway = OuterLayerFactory.instance.getEntityDSGateway();

        if (!userManager.userExists(correctUsername)) {
            dbGateway.addUser(new UserDSRequest(correctUsername, correctPassword, Date.valueOf(LocalDate.now())));
        }
    }

    @Test
    public void testLoginFalseUsername() {
        RegisterRequest request = new RegisterRequest(
                "userDoesn'tExist",
                "password",
                "password",
                Date.valueOf(LocalDate.now()));



        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.USERNAME);
//        Assertions.assertNull(response.userSignedUp());
    }

    @Test
    public void testLoginFalsePassword() {
        RegisterRequest request = new RegisterRequest(
                "userDoesn'tExist",
                "password",
                "password",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertNull(response.userSignedUp());
    }

    @Test
    public void testLoginUserExists() {
        RegisterRequest request = new RegisterRequest(
                correctUsername,
                correctPassword,
                correctPasswordConfirm,
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);

//        User user = response.user();
//        Assertions.assertEquals(user.getUsername(), correctUsername);
//        Assertions.assertTrue(user.isPassword(correctPassword));
    }

}
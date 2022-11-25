package RegistrationTest;

import RegisterUseCase.*;
import db.UserDSRequest;
import db.iEntityDBGateway;
import entities.UserManager;
import main.OuterLayerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;


class RegisterPresenterTest {

    private static RegisterController controller;
    private static UserManager userManager;
    private static final String correctUsername = "database";
    private static final String correctPassword = "password";
    private static final String correctPasswordConfirm = "password";

    @BeforeAll
    public static void setUp() {
        controller = new RegisterController();
        userManager = UserManager.instance;
        iEntityDBGateway dbGateway = OuterLayerFactory.instance.getEntityDSGateway();

        if (!userManager.userExists(correctUsername)) {
            dbGateway.addUser(new UserDSRequest(correctUsername, correctPassword, Date.valueOf(LocalDate.now())));
        }
    }

    /**
     * Inputs a correct combination with no issues to return RegisterError.NONE
     */
    @Test
    public void testNoIssue() {
        // make a random name
        String username = "username" + (int)(Math.random() * 100000);
        while (userManager.userExists(username)) { // creating a unique username that hasn't been used
            username = "username" + (int)(Math.random() * 100000);
        }
        RegisterRequest request = new RegisterRequest(
                username,
                "password",
                "password",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.NONE);

    }

    /**
     * Inputs invalid passwords to receive RegisterError.PASSWORD_INVALID
     */
    @Test
    public void testShortPassword() {
        RegisterRequest request = new RegisterRequest(
                "userDoesn'tExist",
                "h1",
                "h1",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.PASSWORD_INVALID);
    }


    /**
     * Inputs a username that is already taken
     */
    @Test
    public void testUserExistsError() {
        RegisterRequest request = new RegisterRequest(
                correctUsername,
                correctPassword,
                correctPasswordConfirm,
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.USERNAME);

    }

    /**
     * Inputs different passwords to receive RegisterError.PASSWORD_NOT_MATCH
     */
    @Test
    public void testDifferentPasswordsError() {
        RegisterRequest request = new RegisterRequest(
                "RandomName",
                "PasswordNotSame",
                "PasswordIsSame",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.PASSWORD_NOT_MATCH);

    }


    /**
     * Space in Username
     */
    @Test
    public void testSpacedUsername() {
        RegisterRequest request = new RegisterRequest(
                "Random Name",
                "PasswordNotSame",
                "PasswordIsSame",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.USERNAME);

    }
    /**
     * Testing Long Username
     */
    @Test
    public void testLongUsername() {
        // Building a long username that is 51 characters long
        StringBuilder longUsername = new StringBuilder("a");
        longUsername.append("a".repeat(50));
        RegisterRequest request = new RegisterRequest(
                longUsername.toString(),
                "PasswordNotSame",
                "PasswordIsSame",
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.USERNAME);

    }

    /**
     * Testing Long Username
     */
    @Test
    public void testLongPassword() {
        // Building a long username that is 51 characters long
        StringBuilder longPassword = new StringBuilder("a");
        longPassword.append("a".repeat(50));
        RegisterRequest request = new RegisterRequest(
                "username",
                longPassword.toString(),
                longPassword.toString(),
                Date.valueOf(LocalDate.now()));

        RegisterResponse response = controller.signUpUser(request);
        Assertions.assertEquals(response.userSignedUp(), RegisterError.PASSWORD_INVALID);

    }

}
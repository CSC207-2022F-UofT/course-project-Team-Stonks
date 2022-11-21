package PortfolioCreationTest;

import LoginUseCase.UserLoginController;
import LoginUseCase.UserLoginInteractor;
import PortfolioCreationUseCase.*;
import RegisterUseCase.RegisterInteractor;
import db.EntitySQLGateway;
import entities.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;


public class PortfolioCreationTest {

    private static PortfolioCreationController controller;

    private static final String username = "TestUsername";
    private static final String password = "TestPassword";

    private static final String portfolioName = "Portfolio1";
    private static User user;

    @BeforeAll
    public static void setUp(){
        RegisterInteractor registerInteractor = new RegisterInteractor();
        registerInteractor.signUpUser(username, password, password, Date.valueOf(LocalDate.now()));

        UserLoginInteractor loginInteractor = new UserLoginInteractor();
        user = loginInteractor.loginUser(username, password, Date.valueOf(LocalDate.now()));

        controller = new PortfolioCreationController(user);
    }

    @Test
    public void testNewPortfolio(){
        PortfolioCreationRequest request = new PortfolioCreationRequest(portfolioName);
        PortfolioCreationResponse response = controller.createPortfolio(request);

        Assertions.assertTrue(user.getPortfolioNames().contains(portfolioName));
    }

}

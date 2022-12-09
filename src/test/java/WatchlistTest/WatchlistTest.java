package WatchlistTest;

import UseCases.LoginUseCase.UserLoginInteractor;
import UseCases.PortfolioCreationUseCase.PortfolioCreationInteractor;
import UseCases.PortfolioCreationUseCase.PortfolioSelectedInteractor;
import UseCases.RegisterUseCase.RegisterInteractor;
import UseCases.WatchlistUseCase.*;
import db.EntityDBGateway;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class WatchlistTest {

    private static WatchlistUseCaseInteractor interactor;

    private static final String symbol = "GOOG";
    private static final Float value = 93.00f;
    private static final String username = "WatchlistTestUser";

    @BeforeAll
    public static void setUp() {
        Date date = new Date(100);
        RegisterInteractor interactor1 = new RegisterInteractor();

        EntityDBGateway dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
        dbGateway.deleteUser(username);

        interactor1.signUpUser(username, "password", "password", date);

        UserLoginInteractor interactor2 = new UserLoginInteractor();
        User user = interactor2.loginUser(username, "password", date);

        PortfolioCreationInteractor interactor3 = new PortfolioCreationInteractor(user);
        interactor3.makeNewPortfolio("newPortfolio");

        PortfolioSelectedInteractor interactor4 = new PortfolioSelectedInteractor();
        interactor4.populatePortfolio(user, "newPortfolio");

        Portfolio port = user.getPortfolio("newPortfolio");

        interactor = new WatchlistUseCaseInteractor();
    }

    /**
     * isValidStockSymbolTest()
     * Test if the current stock symbol is valid.
     */
    @Test
    public void isValidStockSymbolTest() {
        assert WatchlistAddGUI.isValidStockSymbol(symbol);
    }

    /**
     * @Test
     * AddStockToWatchlistTest()
     * Test that the user can add a stock to their watchlist.
     */
    @Test
    public void AddStockToWatchlistTest() throws IOException {
        interactor = new WatchlistUseCaseInteractor();
        WatchlistInputRequest req = new WatchlistInputRequest(symbol, value, username, "above");
        WatchlistOutputResponse res = interactor.addStockToWatchlist(req);

        assertEquals("The stock with symbol " + symbol + " should have been added to the watchlist", res.getSymbol(), null);
    }


    /**
     * RemoveStockToWatchlistTest()
     * Test that the user can remove stock from their watchlist.
     */
    @Test
    public void RemoveStockToWatchlistTest(){
        WatchlistUseCaseInteractor interactor = new WatchlistUseCaseInteractor();

        WatchlistOutputResponse res = interactor.removeStockFromWatchlist(symbol, username);
        assertEquals("The stock with symbol " + symbol + " should have been removed from the watchlist", res.getSymbol(), username);
    }

}
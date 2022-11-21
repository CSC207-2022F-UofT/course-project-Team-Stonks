package BuyStockTest;

import BuyStockUseCase.BuyInputRequest;
import BuyStockUseCase.BuyOutputResponse;
import BuyStockUseCase.BuyUseCaseInteractor;
import LoginUseCase.UserLoginInteractor;
import PortfolioCreationUseCase.PortfolioCreationError;
import PortfolioCreationUseCase.PortfolioCreationInteractor;
import RegisterUseCase.RegisterInteractor;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

public class BuyStockTest {

    private static Portfolio port;
    private static final String symbol = "TSLA";
    private static final String symbol2 = "AMZN";
    private static BuyUseCaseInteractor interactor;


    @BeforeAll
    public static void setUp() {
        Date date = new Date(100);
        RegisterInteractor interactor1 = new RegisterInteractor();
        interactor1.signUpUser("TestUser2", "password", "password", date);

        UserLoginInteractor interactor2 = new UserLoginInteractor();
        User user = interactor2.loginUser("TestUser", "password", date);

        PortfolioCreationInteractor interactor3 = new PortfolioCreationInteractor(user);
        int tag = 0;
        while (interactor3.makeNewPortfolio("newPortfolio" + tag) == PortfolioCreationError.DUPLICATE_NAME){
            tag += 1;
        }

        port = user.getPortfolio("newPortfolio" + tag);

        interactor = new BuyUseCaseInteractor();
    }

    @Test
    public void buyTSLAStockTest() {
        BuyInputRequest req = new BuyInputRequest(symbol, 5,port);
        try {
            interactor.buyStock(req);
        } catch(IOException ignored) {}

        Map<String, Stock> map = port.getSymbolToStock();

        Stock stock = map.get("TSLA");

        assert stock.getQuantity() == 5;
    }

    @Test
    public void buyStockInsufficientFundsTest() {
        BuyInputRequest req = new BuyInputRequest(symbol2, 1000,port);
        BuyOutputResponse res = new BuyOutputResponse(true);
        try {
            res = interactor.buyStock(req);
        } catch(IOException ignored) {}

        Map<String, Stock> map = port.getSymbolToStock();

        Stock stock = map.get("AMZN");

        assert !res.getOutput();
        assert stock == null;
    }
}

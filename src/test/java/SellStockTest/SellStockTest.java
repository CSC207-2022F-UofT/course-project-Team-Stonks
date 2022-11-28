package SellStockTest;

import APIInterface.StockAPIAccess;
import APIInterface.StockAPIRequest;
import APIInterface.StockAPIResponse;
import SellStockUseCase.SellUseCaseInteractor;
import SellStockUseCase.SellInputRequest;
import SellStockUseCase.SellOutputResponse;
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
import java.util.Objects;

public class SellStockTest {

    private static SellUseCaseInteractor interactor;
    private static Portfolio portfolio;
    private static final String symbol = "AAPL";
    private static final int quantity = 10;
    private static final int sellQuant = 4;
    private static final int invalidQuant = 100;
    private static final String username = "SellTestUser";


    @BeforeAll
    public static void SetUp() throws IOException {
        Date date = new Date(100);
        RegisterInteractor interactor1 = new RegisterInteractor();
        interactor1.signUpUser(username, "password", "password", date);

        UserLoginInteractor interactor2 = new UserLoginInteractor();
        User user = interactor2.loginUser(username, "password", date);

        PortfolioCreationInteractor interactor3 = new PortfolioCreationInteractor(user);
        int tag = 0;
        while (interactor3.makeNewPortfolio("newPortfolio" + tag) == PortfolioCreationError.DUPLICATE_NAME){
            tag += 1;
        }

        StockAPIAccess access = new StockAPIAccess();
        StockAPIResponse res = access.getPrice(new StockAPIRequest(symbol));
        double price = res.getPrice();
        portfolio = user.getPortfolio("newPortfolio" + tag);
        portfolio.addStock(symbol, price, quantity);
        interactor = new SellUseCaseInteractor();
    }

    @Test
    public void testSellStock(){
        double balance = portfolio.getBalance();
        SellInputRequest sell = new SellInputRequest(portfolio, symbol, sellQuant);
        Map<String, Stock> map = portfolio.getSymbolToStock();
        interactor.sellStock(sell);
        Stock stock = map.get(symbol);
        assert stock.getQuantity() == quantity - sellQuant;
        assert portfolio.getBalance() == balance + sellQuant * stock.getValue();
    }

    @Test
    public void testInvalidSellStock(){
        double balance = portfolio.getBalance();
        SellInputRequest sell = new SellInputRequest(portfolio, symbol, invalidQuant);
        SellOutputResponse response = interactor.sellStock(sell);
        interactor.sellStock(sell);
        assert portfolio.getBalance() == balance;

        assert Objects.equals(response.getMessage(), "Please enter a valid amount.");

    }
    @Test
    public void testNoStock(){
        double balance = portfolio.getBalance();
        SellInputRequest sell = new SellInputRequest(portfolio, "TSLA", sellQuant);
        interactor.sellStock(sell);
        SellOutputResponse response = interactor.sellStock(sell);

        assert portfolio.getBalance() == balance;

        assert Objects.equals(response.getMessage(), "You do not own any of this stock");

    }
}
package BuyStockTest;

import BuyStockUseCase.BuyInputRequest;
import BuyStockUseCase.BuyOutputResponse;
import BuyStockUseCase.BuyUseCaseInteractor;
import db.EntitySQLGateway;
import db.PortfolioDSResponse;
import db.StockDSResponse;
import db.UserDSResponse;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class BuyStockTest {

    private static Portfolio port;
    private static final String symbol = "TSLA";
    private static BuyUseCaseInteractor interactor;


    @BeforeAll
    public static void setUp() {
        UserFactory ufactory = new UserFactory();
        PortfolioFactory factory = new PortfolioFactory();
        EntitySQLGateway gate = new EntitySQLGateway();

        Date date = new Date(2022, 7, 13);

        ArrayList<PortfolioDSResponse> list2 = new ArrayList<>();

        User user = ufactory.createUser("testUser25", "password", date, list2, gate);

        user.addPortfolio("newPortfolio");
        port = user.getPortfolio("newPortfolio");

        interactor = new BuyUseCaseInteractor();
    }

    @Test
    public void buyTSLAStockTest() {
        BuyInputRequest req = new BuyInputRequest(symbol, 5,port);
        BuyOutputResponse res;
        try {
            res = interactor.buyStock(req);
        } catch(IOException ignored) {}

        Map<String, Stock> map = port.getSymbolToStock();

        Stock stock = map.get("TSLA");

        assert stock.getQuantity() == 5;
    }
}

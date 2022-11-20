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
        PortfolioFactory factory = new PortfolioFactory();
        EntitySQLGateway gate = new EntitySQLGateway();

        port = factory.createPortfolio("name", "user", gate);

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

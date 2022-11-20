package main;

import BuyStockUseCase.BuyStockGUI;
import BuyStockUseCase.PortfolioGUI;
import BuyStockUseCase.iBuyStockGUI;
import BuyStockUseCase.iPortfolioGUI;
import SellStockUseCase.SellStockGUI;
import SellStockUseCase.iSellStockGUI;
import LoginUseCase.UserLoginGUI;
import LoginUseCase.iUserLoginGUI;
import PortfolioCreationUseCase.UserGUI;
import PortfolioCreationUseCase.iUserGUI;
import RegisterUseCase.RegistrationPage;
import RegisterUseCase.iRegisterGUI;
import db.EntitySQLGateway;
import db.iEntityDBGateway;

import java.sql.Date;
import java.util.List;

public class OuterLayerFactory {
    public static final OuterLayerFactory instance = new OuterLayerFactory();
    private final iEntityDBGateway entityDBGateway;

    public OuterLayerFactory() {
        entityDBGateway = new EntitySQLGateway();
    }

    public iEntityDBGateway getEntityDSGateway() {
        return entityDBGateway;
    }

    public iUserLoginGUI getUserLoginGUI() {
        return new UserLoginGUI();
    }

    public iUserGUI getUserGUI(String username, List<String> portfolioNames, Date lastLogin) {
        return new UserGUI(username, portfolioNames, lastLogin);
    }

    public iPortfolioGUI getPortfolioGUI(String portfolioName, double balance, String username) {
        return new PortfolioGUI(portfolioName, balance, username);
    }

    public iRegisterGUI getRegisterGUI() {
        return new RegistrationPage();
    }

    public iBuyStockGUI getBuyGUI(String symbol) {
        return new BuyStockGUI(symbol);
    }
    public iSellStockGUI getSellGUI(String symbol) {
        return new SellStockGUI(symbol);
    }
}
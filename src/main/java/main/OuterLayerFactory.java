package main;

import BuyStockUseCase.PortfolioGUI;
import BuyStockUseCase.iPortfolioGUI;
import LoginUseCase.UserLoginGUI;
import LoginUseCase.iUserLoginGUI;
import PortfolioCreationUseCase.UserGUI;
import PortfolioCreationUseCase.iUserGUI;
import db.EntitySQLGateway;
import db.iEntityDBGateway;

import java.sql.Date;
import java.util.List;

public class OuterLayerFactory {
    public static final OuterLayerFactory instance = new OuterLayerFactory();

    public iEntityDBGateway getEntityDSGateway() {
        return new EntitySQLGateway();
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
}
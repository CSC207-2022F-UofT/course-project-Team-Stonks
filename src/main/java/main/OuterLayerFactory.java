package main;

import APIInterface.StockAPIGateway;
import APIInterface.iStockDatabaseGateway;
import BuyStockUseCase.BuyStockGUI;
import BuyStockUseCase.PortfolioGUI;
import BuyStockUseCase.iBuyStockGUI;
import BuyStockUseCase.iPortfolioGUI;
import LeaderboardUseCase.LeaderboardGUI;
import LeaderboardUseCase.iLeaderboardGUI;
import LoginUseCase.UserLoginGUI;
import LoginUseCase.iUserLoginGUI;
import PortfolioCreationUseCase.PortfolioCreationGUI;
import PortfolioCreationUseCase.UserGUI;
import PortfolioCreationUseCase.iPortfolioCreationGUI;
import PortfolioCreationUseCase.iUserGUI;
import RegisterUseCase.RegistrationPage;
import RegisterUseCase.iRegisterGUI;
import SearchStockUseCase.ViewStockGUI;
import SearchStockUseCase.iViewStockGUI;
import SellStockUseCase.SellStockGUI;
import SellStockUseCase.iSellStockGUI;
import db.EntitySQLGateway;
import db.iEntityDBGateway;
import entities.Portfolio;

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

    public iPortfolioCreationGUI getPortfolioCreationGUI() {return new PortfolioCreationGUI();}

    public iPortfolioGUI getPortfolioGUI(Portfolio port, String username, boolean isComp) {
        return new PortfolioGUI(port, username, isComp);
    }

    public iRegisterGUI getRegisterGUI() {
        return new RegistrationPage();
    }

    public iBuyStockGUI getBuyGUI(String symbol, int quantity) {
        return new BuyStockGUI(symbol, quantity);
    }
    public iSellStockGUI getSellGUI(String symbol, int quantity) {
        return new SellStockGUI(symbol, quantity);
    }
    public iLeaderboardGUI getLeaderboardGUI(List<String> topUsers) {
        return new LeaderboardGUI(topUsers);
    }
    public iViewStockGUI getViewStockGUI(String symbol) { return new ViewStockGUI(symbol);}

    public iStockDatabaseGateway getStockDBGateway() {
        return new StockAPIGateway();
    }
}
package main;

import APIInterface.StockAPIGateway;
import APIInterface.iStockDatabaseGateway;
import UseCases.BuyStockUseCase.BuyStockGUI;
import UseCases.BuyStockUseCase.PortfolioGUI;
import UseCases.BuyStockUseCase.iBuyStockGUI;
import UseCases.BuyStockUseCase.iPortfolioGUI;
import UseCases.LeaderboardUseCase.LeaderboardGUI;
import UseCases.LeaderboardUseCase.iLeaderboardGUI;
import UseCases.LoginUseCase.UserLoginGUI;
import UseCases.LoginUseCase.iUserLoginGUI;
import UseCases.PortfolioCreationUseCase.PortfolioCreationGUI;
import UseCases.PortfolioCreationUseCase.UserGUI;
import UseCases.PortfolioCreationUseCase.iPortfolioCreationGUI;
import UseCases.PortfolioCreationUseCase.iUserGUI;
import UseCases.RegisterUseCase.RegistrationPage;
import UseCases.RegisterUseCase.iRegisterGUI;
import UseCases.SearchStockUseCase.ViewStockGUI;
import UseCases.SearchStockUseCase.iViewStockGUI;
import UseCases.SellStockUseCase.SellStockGUI;
import UseCases.SellStockUseCase.iSellStockGUI;
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

    public iBuyStockGUI getBuyGUI(String symbol, int quantity, double balance) {
        return new BuyStockGUI(symbol, quantity, balance);
    }
    
    public iSellStockGUI getSellGUI(String symbol, int quantity) {
        return new SellStockGUI(symbol, quantity);
    }
    
    public iLeaderboardGUI getLeaderboardGUI(List<String> topUsers) {
        return new LeaderboardGUI(topUsers);
    }

    public iViewStockGUI getViewStockGUI(String symbol, Portfolio port) { return new ViewStockGUI(symbol, port);}

    public iStockDatabaseGateway getStockDBGateway() {
        return new StockAPIGateway();
    }
}
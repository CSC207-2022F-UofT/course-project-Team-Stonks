package main;

import BuyStockUseCase.BuyStockGUI;
import BuyStockUseCase.iBuyStockGUI;
import BuyStockUseCase.iPortfolioGUI;
import BuyStockUseCase.PortfolioGUI;
import SellStockUseCase.SellStockGUI;
import SellStockUseCase.iSellStockGUI;
import LoginUseCase.UserLoginGUI;
import LoginUseCase.iUserLoginGUI;
import PortfolioCreationUseCase.UserGUI;
import PortfolioCreationUseCase.iUserGUI;
import PortfolioCreationUseCase.PortfolioCreationGUI;
import PortfolioCreationUseCase.iPortfolioCreationGUI;
import RegisterUseCase.RegistrationPage;
import RegisterUseCase.iRegisterGUI;
import LeaderboardUseCase.iLeaderboardGUI;
import LeaderboardUseCase.LeaderboardGUI;
import db.EntitySQLGateway;
import db.iEntityDBGateway;
import entities.Portfolio;

import java.sql.Date;
import java.util.ArrayList;
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

    public iPortfolioCreationGUI getPortfolioCreationGUI() {return new PortfolioCreationGUI();}

    public iPortfolioGUI getPortfolioGUI(Portfolio port, String username) {
        return new PortfolioGUI(port, username);
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
    public iLeaderboardGUI getLeaderboardGUI(List<String> topUsers) {
        return new LeaderboardGUI(topUsers);
    }
}
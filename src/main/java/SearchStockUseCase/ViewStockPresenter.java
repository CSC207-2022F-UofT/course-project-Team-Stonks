package SearchStockUseCase;


import APIInterface.StockAPIGateway;
import APIInterface.StockAPIRequest;
import BuyStockUseCase.BuyStockPresenter;
import BuyStockUseCase.PortfolioPresenter;
import BuyStockUseCase.iPortfolioGUI;
import SellStockUseCase.SellStockPresenter;
import entities.Portfolio;
import entities.User;
import main.OuterLayerFactory;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class ViewStockPresenter {
    private final iViewStockGUI view;
    private final Portfolio portfolio;
    private final User user;
    private final ViewStockController controller;
    public ViewStockPresenter(iViewStockGUI view, Portfolio portfolio, User user){
        this.view = view;
        this.controller = new ViewStockController(this.view.getStockSymbol());


        try{
            this.controller.searchStock();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.view.setHistData(this.controller.getCurrentHistData());
        try{
            this.view.setStockPrice(this.controller.getCurrentPrice());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.view.loadLabels();
        this.view.updateTable(controller.updateTable(Interval.DAILY));

        this.portfolio = portfolio;
        this.user = user;

        //Setting functionality for buttons
        view.addBuyStockAction(this::onBuyStock);
        view.addSellStockAction(this::onSellStock);
        view.addBackAction(this::onBack);
        view.yearlyButtonAction(this::onYearlyButton);
        view.weeklyButtonAction(this::onWeeklyButton);
        view.todayButtonAction(this::onTodayButton);

    }

    private void onTodayButton(){
        this.view.updateTable(controller.updateTable(Interval.DAILY));
    }
    private void onWeeklyButton() {
        this.view.updateTable(controller.updateTable(Interval.WEEKLY));
    }

    private void onYearlyButton() {
        this.view.updateTable(controller.updateTable(Interval.MONTHLY));
    }


    private void onBack() {
        boolean isComp = this.portfolio.getName().equals(user.getCompPortfolioName());
        view.close();
        new PortfolioPresenter(OuterLayerFactory.instance.getPortfolioGUI(this.portfolio, this.user.getUsername(), isComp),this.portfolio, this.user);
    }

    private void onSellStock() {
        //call Sell Presenter
        view.close();
        int quantity = portfolio.getStockQuantity(view.getStockSymbol());
        new SellStockPresenter(OuterLayerFactory.instance.getSellGUI(view.getStockSymbol(), quantity), this.portfolio, this.user);
    }

    private void onBuyStock(){
        //Call Buy Presenter
        view.close();
        int quantity = portfolio.getStockQuantity(view.getStockSymbol());
        new BuyStockPresenter(OuterLayerFactory.instance.getBuyGUI(view.getStockSymbol(), quantity), this.portfolio, this.user);
    }
}

package SearchStockUseCase;


import java.io.IOException;


public interface iViewStockGUI {
    void addBuyStockAction(Runnable onBuyStock);
    void addSellStockAction(Runnable onSellStock);
    double updatePrice() throws Exception;
    void updateValues() throws IOException;
    void todayButtonAction() throws IOException;
    void weeklyButtonAction() throws IOException;
    void monthlyButtonAction() throws IOException;

    void addBackAction(Runnable onBack);

    String stockMarketStatus();
    void updateTable();
    void close();

    String getStockSymbol();
}

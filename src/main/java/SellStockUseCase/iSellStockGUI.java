package SellStockUseCase;

public interface iSellStockGUI {
     void close();
     void displayQuantityFailure();
     void displayConnectionFailure();
     int getQuantity();
     void addSellAction(Runnable onSell);
     void addGoBackAction(Runnable onBack);
     void displaySuccess();
     String getSymbol();

}

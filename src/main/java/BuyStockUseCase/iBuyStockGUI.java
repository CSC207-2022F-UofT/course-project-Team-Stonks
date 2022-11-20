package BuyStockUseCase;

public interface iBuyStockGUI {
    void addBuyAction(Runnable onLogin);
    void addGoBackAction(Runnable onBack);
    void close();
    void displayBalanceFailure();
    void displayConnectionFailure();
    void displayInvalidInputFailure();
    void displaySuccess();
    String getSymbol();
    int getQuantity() throws NumberFormatException;
}

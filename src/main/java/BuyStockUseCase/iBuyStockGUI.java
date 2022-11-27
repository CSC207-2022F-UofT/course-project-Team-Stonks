package BuyStockUseCase;

public interface iBuyStockGUI {
    /**
     * Interface for the buy stock GUI
     */
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

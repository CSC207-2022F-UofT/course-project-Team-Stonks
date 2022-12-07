package UseCases.BuyStockUseCase;

public interface BuyStockView {
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
    void updateBalanceLabel(double balance);
    void updateQuantityLabel(int quant);
}
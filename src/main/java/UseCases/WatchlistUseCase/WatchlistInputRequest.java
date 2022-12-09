package UseCases.WatchlistUseCase;

public class WatchlistInputRequest {

    private final String symbol;
    private final Float value;
    private final String username;
    private final String condition;

    public WatchlistInputRequest(String symbol, Float value, String username, String condition){
        this.symbol = symbol;
        this.value = value;
        this.username = username;
        this.condition = condition;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Float getValue() {
        return this.value;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getPortfolioId() {
        return null;
    }

}

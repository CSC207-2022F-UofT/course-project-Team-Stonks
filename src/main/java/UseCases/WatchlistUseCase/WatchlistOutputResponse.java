package UseCases.WatchlistUseCase;

public class WatchlistOutputResponse {

    private String symbol;
    private Float value;
    private String username;
    private String condition;

    public WatchlistOutputResponse(
            String symbol,
            Float value,
            String username,
            String condition
    ){
        this.symbol = symbol;
        this.value = value;
        this.username = username;
        this.condition = condition;
    }

    public Object getSymbol() {
        return symbol;
    }

    public Object getValue() {
        return value;
    }

    public Object getUsername() {
        return username;
    }

    public Object getCondition() {
        return condition;
    }


}

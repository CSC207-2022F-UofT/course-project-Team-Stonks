package db;

public class WatchlistDSRequest {

    private String stockSymbol;
    private String stockType;
    private Float stockValue;
    private String username;
    private String condition;

    public WatchlistDSRequest(String symbol, String type, Float value, String username, String condition){
        this.stockSymbol = symbol;
        this.stockType = type;
        this.stockValue = value;
        this.username = username;
        this.condition = condition;

    }

    public String getSymbol() {
        return this.stockSymbol;
    }

    public String getType() {
        return this.stockType;
    }

    public Float getValue() {
        return this.stockValue;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCondition() {
        return this.condition;
    }


}

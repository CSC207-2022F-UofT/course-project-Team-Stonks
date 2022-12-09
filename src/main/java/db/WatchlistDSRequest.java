package db;

public class WatchlistDSRequest {

    private String stockSymbol;
    private Float stockValue;
    private String username;
    private String condition;
    private String portfolioId;

    public WatchlistDSRequest( 
        String username, 
        String symbol, 
        Float value, 
        String condition
    ){
        this.username = username;
        this.stockSymbol = symbol;
        this.stockValue = value;
        this.condition = condition;

    }

    public String getSymbol() {
        return this.stockSymbol;
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

    public String getPortfolioId() {
        return this.portfolioId;
    }

}

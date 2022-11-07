package db;

public record StockDSRequest(String symbol, double value, int amount, String username, String portfolioName) {
}
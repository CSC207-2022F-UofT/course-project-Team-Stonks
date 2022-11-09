package db;

public record StockDSRequest(String symbol, double value, int quantity, String username, String portfolioName) {
}
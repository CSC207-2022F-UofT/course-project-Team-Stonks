package db;

/**
 * Request model class containing input for creating a new portfolio
 * object in the entity database
 */
public record PortfolioDSRequest(String name, double balance, String username) {
}
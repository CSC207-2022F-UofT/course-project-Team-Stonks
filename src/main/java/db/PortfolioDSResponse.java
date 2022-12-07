package db;

import java.util.List;

/**
 * Response model class containing the information for creating a new portfolio
 * object in the application from the entity database
 */
public record PortfolioDSResponse(String name, double balance, List<StockDSResponse> stocks) {

    /**
     * @return String name of the portfolio
     * Getter for the name of the portfolio
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * @return double balance of the portfolio
     * Getter for the balance of the portfolio
     */
    @Override
    public double balance() {
        return this.balance;
    }

    /**
     * @return List<StockDSResponse> stocks of the portfolio
     * Getter for the stocks of the portfolio
     */
    @Override
    public List<StockDSResponse> stocks() {
        return this.stocks;
    }
}
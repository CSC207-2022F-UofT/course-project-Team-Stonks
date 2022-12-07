package entities;

import db.PortfolioDSResponse;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFactory {
    /**
     * This class is responsible for creating a User object
     */
    private final PortfolioFactory portfolioFactory = new PortfolioFactory();

    public User createUser(String username, String password, Date creationTime, String compPort, List<PortfolioDSResponse> portfolioResponses) {
        Map<String, Portfolio> portfolios = new HashMap<>();

        for (PortfolioDSResponse portfolio : portfolioResponses) {
            portfolios.put(portfolio.name(), portfolioFactory.createPortfolio(portfolio.balance(), portfolio.name(), username, portfolio.stocks()));
        }

        return new User(username, password, creationTime, compPort, portfolios);
    }
}
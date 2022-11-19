package entities;

import db.PortfolioDSResponse;
import db.iEntityDBGateway;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFactory {
    private final PortfolioFactory portfolioFactory = new PortfolioFactory();

    public User createUser(String username, String password, Date creationTime, List<PortfolioDSResponse> portfolioResponses, iEntityDBGateway dbGateway) {
        Map<String, Portfolio> portfolios = new HashMap<>();

        for (PortfolioDSResponse portfolio : portfolioResponses) {
            portfolios.put(portfolio.getName(), portfolioFactory.createPortfolio(portfolio.getBalance(), portfolio.getName(), username, portfolio.getStocks(), dbGateway));
        }

        return new User(username, password, creationTime, portfolios, dbGateway);
    }
}
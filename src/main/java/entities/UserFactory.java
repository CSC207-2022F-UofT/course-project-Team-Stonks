package entities;

import db.PortfolioDSResponse;
import db.UserDSRequest;
import db.iEntityDBGateway;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFactory {
    private final PortfolioFactory portfolioFactory = new PortfolioFactory();

    public User createUser(String username, String password, Date creationTime, iEntityDBGateway dbGateway) {
        dbGateway.addUser(new UserDSRequest(username, password, creationTime));
        return new User(username, password, creationTime, dbGateway);
    }

    public User createUser(String username, String password, Date creationTime, List<PortfolioDSResponse> portfolioResponses, iEntityDBGateway dbGateway) {
        Map<String, Portfolio> portfolios = new HashMap<>();

        for (PortfolioDSResponse portfolio : portfolioResponses) {
            portfolios.put(portfolio.getName(), portfolioFactory.createPortfolio(portfolio.getBalance(), portfolio.getName(), portfolio.getStocks(), dbGateway));
        }

        return new User(username, password, creationTime, portfolios, dbGateway);
    }
}
package entities;

import db.PortfolioDSRequest;
import db.PortfolioDSResponse;
import db.iEntityDBGateway;

import java.util.*;

public class UserFactory {
    private PortfolioFactory portfolioFactory = new PortfolioFactory();

    public User createUser(String username, String password, Date creationTime, iEntityDBGateway dbGateway) {
        return new User(username, password, creationTime, dbGateway);
    }

    public User createUser(String username, String password, Date creationTime, List<PortfolioDSResponse> portfolioResponses, iEntityDBGateway dbGateway) {
        Map<String, Portfolio> portfolios = new HashMap<>();

        for (PortfolioDSResponse portfolio : portfolioResponses) {
            portfolios.put(portfolio.name(), portfolioFactory.createPortfolio(portfolio.balance(), portfolio.name(), portfolio.stocks(), dbGateway));
        }

        return new User(username, password, creationTime, portfolios, dbGateway);
    }
}
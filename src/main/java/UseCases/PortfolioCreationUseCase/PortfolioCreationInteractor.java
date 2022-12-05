package UseCases.PortfolioCreationUseCase;

import db.PortfolioDSRequest;
import db.EntityDBGateway;
import entities.PortfolioFactory;
import entities.User;
import main.OuterLayerFactory;

public class PortfolioCreationInteractor {
    private final User user;
    private final EntityDBGateway dbGateway;

    public PortfolioCreationInteractor(User user) {
        this.user = user;
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }

    public PortfolioCreationError makeNewPortfolio(String newPortfolioName) {
        if (newPortfolioName.equals("")) {
            return PortfolioCreationError.INVALID_NAME;
        }
        else if (user.getPortfolioNames().contains(newPortfolioName)) {
            return PortfolioCreationError.DUPLICATE_NAME;
        }

        user.addPortfolio(newPortfolioName);
        dbGateway.addPortfolio(new PortfolioDSRequest(newPortfolioName, PortfolioFactory.BALANCE, user.getUsername()));

        return PortfolioCreationError.NONE;

    }
}
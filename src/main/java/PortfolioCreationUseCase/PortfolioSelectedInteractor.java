package PortfolioCreationUseCase;

import entities.User;

public class PortfolioCreationInteractor {
    private final User user;

    public PortfolioCreationInteractor(User user) {
        this.user = user;
    }

    public PortfolioCreationError makeNewPortfolio(String newPortfolioName) {
        if (newPortfolioName.equals("")) {
            return PortfolioCreationError.INVALID_NAME;
        }
        else if (user.getPortfolioNames().contains(newPortfolioName)) {
            return PortfolioCreationError.DUPLICATE_NAME;
        }

        user.addPortfolio(newPortfolioName);

        return PortfolioCreationError.NONE;

    }
}
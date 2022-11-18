package PortfolioCreationUseCase;

import entities.User;

public final class PortfolioCreationRequest {
    private final User user;
    private final String portfolioName;

    public PortfolioCreationRequest(
            User user, String portfolioName) {
        this.user = user;
        this.portfolioName = portfolioName;
    }

    public User getUser() {
        return user;
    }

    public String getPortfolioName() {
        return portfolioName;
    }
}
package UseCases.PortfolioCreationUseCase;

import entities.User;

public record PortfolioSelectedRequest(User user, String portfolioName) {
}
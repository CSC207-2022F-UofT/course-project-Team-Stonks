package UseCases.PortfolioCreationUseCase;

import entities.User;

public record CompPortRequest(User user, String compPort) {
}
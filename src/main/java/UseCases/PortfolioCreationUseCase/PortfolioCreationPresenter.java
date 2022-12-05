package UseCases.PortfolioCreationUseCase;

import entities.User;
import main.OuterLayerFactory;

import java.util.ArrayList;

public class PortfolioCreationPresenter {
    private final iPortfolioCreationGUI view;
    private final PortfolioCreationController controller;
    private final User user;

    public PortfolioCreationPresenter(iPortfolioCreationGUI view, User user) {
        this.view = view;
        this.user = user;
        controller = new PortfolioCreationController(user);

        view.addCreatePortfolioAction(this::createPortfolio);
        view.addBackAction(this::onBack);
    }

    private void createPortfolio(){
        PortfolioCreationRequest request = new PortfolioCreationRequest(view.getNewPortfolioName());

        PortfolioCreationResponse response = controller.createPortfolio(request);

        if (response.portfolioCreated() == PortfolioCreationError.DUPLICATE_NAME) {
            view.presentDuplicateNameError();
        } else if (response.portfolioCreated() == PortfolioCreationError.INVALID_NAME) {
            view.presentNameInvalidError();
        } else {
            onBack();
        }
    }

    private void onBack(){
        view.close();
        new UserPresenter(
                OuterLayerFactory.instance.getUserGUI(
                        user.getUsername(),
                        new ArrayList<>(user.getPortfolioNames()),
                        user.getLastLogin()),
                user);
    }
}
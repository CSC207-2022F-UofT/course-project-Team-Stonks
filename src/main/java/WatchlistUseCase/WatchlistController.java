package WatchlistUseCase;

import db.WatchlistDSRequest;
import db.iEntityDBGateway;
import main.OuterLayerFactory;

public class WatchlistController {
    iEntityDBGateway dbGateway;

    public WatchlistController() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }

    public WatchlistOutputResponse addWatchlist(WatchlistInputRequest req) {
        WatchlistUseCaseInteractor interactor = new WatchlistUseCaseInteractor();
        return interactor.addStockToWatchlist(req);
    }

    public WatchlistOutputResponse removeWatchlist(WatchlistInputRequest req) {
        WatchlistUseCaseInteractor interactor = new WatchlistUseCaseInteractor();
        return interactor.removeStockFromWatchlist(req);
    }

    public WatchlistOutputResponse addStockToWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        String type = req.getType();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.addWatchlist(new WatchlistDSRequest(symbol, type, value, username, condition));

        return new WatchlistOutputResponse(true);
    }

    public WatchlistOutputResponse removeStockFromWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        String type = req.getType();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.removeWatchlist(new WatchlistDSRequest(symbol, type, value, username, condition));

        return new WatchlistOutputResponse(true);
    }

    public WatchlistOutputResponse updateWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        String type = req.getType();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.updateWatchlist(symbol, type, value, username, condition);

        return new WatchlistOutputResponse(true);
    }

    public WatchlistOutputResponse getWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        String type = req.getType();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.getWatchlist(symbol, type, value, username, condition);

        return new WatchlistOutputResponse(true);
    }

}

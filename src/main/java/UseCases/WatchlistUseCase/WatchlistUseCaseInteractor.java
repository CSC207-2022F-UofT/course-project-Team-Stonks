package UseCases.WatchlistUseCase;

import db.WatchlistDSRequest;
import db.EntityDBGateway;
import main.OuterLayerFactory;

public class WatchlistUseCaseInteractor {
    EntityDBGateway dbGateway;

    public WatchlistUseCaseInteractor() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }

    public WatchlistOutputResponse addStockToWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.addWatchlist(new WatchlistDSRequest(username, symbol, value, condition));

        return new WatchlistOutputResponse(condition, value, condition, condition);
    }

    public WatchlistOutputResponse removeStockFromWatchlist(String symbol, String username) {
        dbGateway.removeWatchlist(symbol, username);

        return new WatchlistOutputResponse(username, null, username, username);
    }

    public WatchlistOutputResponse updateWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.updateWatchlist(username, symbol, value, condition);

        return new WatchlistOutputResponse(condition, value, condition, condition);
    }

    public WatchlistOutputResponse getWatchlist(WatchlistInputRequest req) {
        String symbol = req.getSymbol();
        Float value = req.getValue();
        String username = req.getUsername();
        String condition = req.getCondition();

        dbGateway.getWatchlist(username, symbol, value, condition);

        return new WatchlistOutputResponse(condition, value, condition, condition);
    }

    public WatchlistOutputResponse getAllWatchlist() {

        dbGateway.getAllWatchlists();

        return new WatchlistOutputResponse(null, null, null, null);
    }

}


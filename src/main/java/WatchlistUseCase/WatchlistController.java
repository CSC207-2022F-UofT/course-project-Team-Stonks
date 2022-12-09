package WatchlistUseCase;

import java.util.List;

import db.WatchlistDSRequest;
import db.EntityDBGateway;
import main.OuterLayerFactory;

public class WatchlistController {
    EntityDBGateway dbGateway;

    public WatchlistController() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }



    public WatchlistOutputResponse addStockToWatchlist(String username, String symbol, Float value,String condition) {
      
        dbGateway.addWatchlist(new WatchlistDSRequest(username, symbol, value, condition));

        return new WatchlistOutputResponse();
    }

    public WatchlistOutputResponse removeStockFromWatchlist(String symbol, String username) {
        dbGateway.removeWatchlist(symbol, username);

        return new WatchlistOutputResponse();
    }



    public List<WatchlistDSRequest> getAllWatchlists() {
        return dbGateway.getAllWatchlists();
    }

}

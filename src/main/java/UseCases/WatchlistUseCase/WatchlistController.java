package UseCases.WatchlistUseCase;

import java.util.List;

import db.WatchlistDSRequest;
import db.EntityDBGateway;
import main.OuterLayerFactory;

public class WatchlistController {
    EntityDBGateway dbGateway;

    public WatchlistController() {
        dbGateway = OuterLayerFactory.instance.getEntityDSGateway();
    }

    /**
     * Function to add a stock to a users watchlist
     * @param username --> username of the account adding the watchlist item
     * @param symbol --> symbol of the stock to be added
     * @param value --> dollar value of the stock to be notified at
     * @param condition --> condition to be notified at if the stock goes above or below the set value
     */

    public WatchlistOutputResponse addStockToWatchlist(String username, String symbol, Float value,String condition) {
      
        dbGateway.addWatchlist(new WatchlistDSRequest(username, symbol, value, condition));

        return new WatchlistOutputResponse();
    }
    /**
     * Function to remove a stock from watchlist
     * @param symbol --> stock symbol you want to remove
     * @param username --> username of the user to remove it from their watchlist
     */
    public WatchlistOutputResponse removeStockFromWatchlist(String symbol, String username) {
        dbGateway.removeWatchlist(symbol, username);

        return new WatchlistOutputResponse();
    }


    /**
     * Get all watchlist items from the database
     */
    public List<WatchlistDSRequest> getAllWatchlists() {
        return dbGateway.getAllWatchlists();
    }

}

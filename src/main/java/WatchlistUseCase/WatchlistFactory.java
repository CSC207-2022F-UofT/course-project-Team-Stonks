package WatchlistUseCase;
import db.iEntityDBGateway;

public class WatchlistFactory {

    public WatchlistItem createWatchlistItem(String stockId, Boolean isAbove, Float value, iEntityDBGateway dbGateway){

        return new WatchlistItem();
    }
}

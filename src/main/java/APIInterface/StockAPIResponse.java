package APIInterface;

import yahoofinance.histquotes.HistoricalQuote;
import java.util.List;

/**
 * @param price Response model class containing output from an individual price request to the
 *              stock price API.
 *              Historical data is provided as a List of HistoricalQuote objects from the API.
 *              For more information on the HistoricalQuote class and its attributes,
 *              see <a href="https://financequotes-api.com/javadoc/yahoofinance/histquotes/HistoricalQuote.html">its documentation.</a>.
 */
public record StockAPIResponse(double price, List<HistoricalQuote> histData) {

    /**
     * @return the price
     * Getter for the price
     */
    @Override
    public double price() {
        return this.price;
    }

    /**
     * @return the histData
     * Getter for the histData
     */
    @Override
    public List<HistoricalQuote> histData() {
        return histData;
    }
}
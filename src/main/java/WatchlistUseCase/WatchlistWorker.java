package WatchlistUseCase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
  
import db.WatchlistDSRequest;

/**
 * This class is responsible for all cron jobs related to the watchlist.
 */
public class WatchlistWorker {

    public void checkWatchlists(String username) {
  
        WatchlistController controller = new WatchlistController();
        List<WatchlistDSRequest> response = controller.getAllWatchlists();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("WatchlistWorker.checkWatchlists() is running.");
            
                for (WatchlistDSRequest watchlist : response) {
    
                    if (!watchlist.getUsername().equals(username)) {
                        continue;
                    }

                    String symbol = watchlist.getSymbol();
                    String condition = watchlist.getCondition();
                    double value = watchlist.getValue();

                    try {
                        URL url = new URL("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol
                                + "&apikey=ZQZQZQZQZQZQZQZQZQZQ");
                        
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Accept", "application/json");
                        BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                        String output;
                        String price = "";

                        while ((output = br.readLine()) != null) {
                            
                            if (output.contains("price")) {
                                price = output.substring(output.indexOf("price") + 8, output.indexOf("price") + 15);
                                price = price.replaceAll("[^0-9.]", "");
                                break;
                            }
                        }
                        connection.disconnect();

                        double currentPrice = Double.parseDouble(price);
                        if (condition.equals("Above") && currentPrice > value) {
                            JOptionPane.showMessageDialog(null, "The stock " + symbol + " is above " + value + ".");
                        } else if (condition.equals("Below") && currentPrice < value) {
                            JOptionPane.showMessageDialog(null, "The stock " + symbol + " is below " + value + ".");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("WatchlistWorker.checkWatchlists() is done.");

            }
        }, 0, 60 * 1000);
    }

    public void run(String username) {
        checkWatchlists(username);
    }
}

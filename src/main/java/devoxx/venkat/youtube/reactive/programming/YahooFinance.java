package devoxx.venkat.youtube.reactive.programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class YahooFinance {
    public static double getPrice(final String ticker) {
        try {
            Thread.sleep(1000);
            final URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + ticker + "&f=snbaopl1");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().limit(1).findFirst().get();
            final String[] dataItems = data.split(",");
            double price = Double.parseDouble(dataItems[dataItems.length - 1]);
            return price;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

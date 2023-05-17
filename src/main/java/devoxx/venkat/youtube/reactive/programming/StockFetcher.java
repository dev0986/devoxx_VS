package devoxx.venkat.youtube.reactive.programming;

import java.util.concurrent.ThreadLocalRandom;

public class StockFetcher {

    public static StockInfo fetch(String symbol) {
//        if (Math.random() > 0.5) {
//            throw new RuntimeException("ohoh");
//        }
        return new StockInfo(symbol
                , YahooFinance.getPrice(symbol));
    }
}

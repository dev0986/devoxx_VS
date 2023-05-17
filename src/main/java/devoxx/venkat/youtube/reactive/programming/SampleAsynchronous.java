package devoxx.venkat.youtube.reactive.programming;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
/*
How many Threads?
If your task is computation intensive then give
no more Threads than the number of cores.

If your task is IO intensive then give
no more Threads than the number of cores.

HOW MANY???
# of cores / (1 - blocking factor)
# of cores / (1 -0.5) = 2 * # cores
0.5 here is -> If a Thread is blocked 50% of times.
Blocking factor is between 0 and less than 1.
*/


public class SampleAsynchronous {
    public static void main(String[] args) throws InterruptedException {
        List<String> symbols =
                Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        feed
                .subscribeOn(Schedulers.io()) //different threads, varying the Asynchrous
                .subscribe(SampleAsynchronous::printStockInfo);

        Thread.sleep(10000);
    }

    private static void printStockInfo(StockInfo stockInfo) {
        System.out.println("Thread: " + Thread.currentThread());
        System.out.println(stockInfo);
    }
}

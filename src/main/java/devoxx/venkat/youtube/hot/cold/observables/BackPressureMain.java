package devoxx.venkat.youtube.hot.cold.observables;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class BackPressureMain {

    public static void main(String[] args) throws InterruptedException {
        List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");


        Observable<Integer> feed =
                StockServer.getData()
                        .subscribeOn(Schedulers.io())
                        .onBackpressureBuffer();
        // If I am busy doing stuff, you send data
        // and i not responding.
        // give me fresh data and drop before data

        feed.subscribe(System.out::println);

        Thread.sleep(5000);

        feed.subscribe(System.out::println);

        Thread.sleep(30000);
    }

    private static void handleError(Throwable throwable){
        System.out.println(throwable);
    }
}


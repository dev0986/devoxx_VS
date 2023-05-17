package devoxx.venkat.youtube.hot.cold.observables;

import devoxx.venkat.youtube.reactive.programming.ErrorJavaObservableMain;
import org.w3c.dom.ls.LSOutput;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class HotColdObservablesMain {

    public static void main(String[] args) throws InterruptedException {
        List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

        //hot vs Cold
        //Cold - Every subscriber starts fresh subscription
        //Hot -

//        -> numbers 0,1,2,3,4,5 -> Cold (Freshly start from 0)
//        Iterator -> 1st iterator -> start iterating
//                2nd iterator - starts from the strart of Collection



        Observable<Integer> feed =
                StockServer.getData()
                                .subscribeOn(Schedulers.io())
                                        //.publish();
                                .share(); // In sync (sharing stream of data)
        //cold subscription

        feed.subscribe(System.out::println);

        Thread.sleep(5000);

        feed.subscribe(System.out::println);

        Thread.sleep(30000);
        // Not shared use case :: Data and somebody wants to analyse data -> Cold observable (Start from beginning)
        // Observing a very live event -> sport event happening, analysis on current sport
        // process -> observing live ......
    }

    private static void handleError(Throwable throwable){
        System.out.println(throwable);
    }
}

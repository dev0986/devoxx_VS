package devoxx.venkat.youtube.reactive.programming;

//1 hour 53 minutes

import org.w3c.dom.ls.LSOutput;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class ErrorJavaObservableMain {

    public static void main(String[] args) throws InterruptedException {
        List<String> symbols =
                Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("Got Observable");

        //Pipeline of Observables //Remove take(10) if Stream .....enable
//        feed.take(10).map(stockInfo -> new StockInfo(stockInfo.getTicker(), stockInfo.getPrice() * 0.9))
//
//                .filter(stockInfo -> stockInfo.getPrice() > 100.0)
//                .onErrorResumeNext(throwable -> callBackUp(throwable, symbols)).
//                subscribe(System.out::println,
//                        ErrorJavaObservableMain::handleError);

        //take()
//        feed.take(10) // take
//                .subscribe(System.out::println,
//                        ErrorJavaObservableMain::handleError);

        //takeWhile
    /*
        when takeWhile(condition) is met , takeWhile does 2 things:
        onCompledte downstream
        unsunsbcr upstream

                        Done sent me more data         I am Done
                        unsubscribe()/                 onCompleted()
                                  <-----            ----->
                    source    ->        takeWhile()           ->    downstream

     */

        feed.takeWhile(stockInfo -> stockInfo.getPrice() > 150)
                .subscribe(System.out::println,
                        ErrorJavaObservableMain::handleError,
                        () -> System.out.println("DONE"));

        //skipWhile()
        //100 - 200
//        feed.skipWhile(stockInfo -> stockInfo.getPrice() < 100)
//                .subscribe(System.out::println,
//                        ErrorJavaObservableMain::handleError,
//                        () -> System.out.println("DONE"));

        //takeWhile() -> switches -> keep sending data, when condition met, stop sending data
        //skipWhile() -> switches -> no data until condition is met

        //skip
        feed.skip(30)
                .subscribe(System.out::println,
                        ErrorJavaObservableMain::handleError,
                        () -> System.out.println("DONE"));




    }

    private static Observable<? extends StockInfo> callBackUp(Throwable throwable, List<String> symbols) {
        System.out.println(throwable);
        return StockServer.getFeed(symbols);
    }

    private static void handleError(Throwable throwable) {
        System.out.println(throwable);
    }
}

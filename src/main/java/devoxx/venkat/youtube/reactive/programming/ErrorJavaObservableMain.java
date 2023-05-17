package devoxx.venkat.youtube.reactive.programming;

//1 hour 53 minutes
import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class ErrorJavaObservableMain {

    public static void main(String[] args) throws InterruptedException {
        List<String> symbols =
                Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);

        //Pipeline of Observables
        feed.onErrorResumeNext(throwable -> callBackUp(throwable, symbols)).
                subscribe(System.out::println,
                        ErrorJavaObservableMain::handleError);
    }

    private static Observable<? extends StockInfo> callBackUp(Throwable throwable, List<String> symbols) {
        System.out.println(throwable);
        return StockServer.getFeed(symbols);
    }

    private static void handleError(Throwable throwable) {
        System.out.println(throwable);
    }
}

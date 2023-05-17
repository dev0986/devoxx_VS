package devoxx.venkat.youtube.hot.cold.observables;

import rx.Observable;
import rx.Subscriber;


public class StockServer {

    public static Observable<Integer> getData() {
        return Observable.create(subscriber -> {
            try {
                processRequest(subscriber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static <T> void processRequest(Subscriber<? super Integer> subscriber) throws InterruptedException {
        int count = 0;
        while (true) {
            subscriber.onNext(count++);
            sleep(1000);
        }
    }

    private static void sleep(int i) throws InterruptedException {
        Thread.sleep(1000);
    }


}

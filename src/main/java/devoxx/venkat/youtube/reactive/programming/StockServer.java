package devoxx.venkat.youtube.reactive.programming;

import java.util.List;


import rx.*;


public class StockServer {

    public static Observable<StockInfo> getFeed(List<String> symbols) {
        return Observable.create(
                subscriber -> processRequest(subscriber, symbols)
        );
    }

    private static void processRequest(Subscriber<? super StockInfo> subscriber, List<String> symbols) {

        while (!subscriber.isUnsubscribed()) {
            symbols.stream()
                    .map(StockFetcher::fetch)
                    //.filter(data -> !subscriber.isUnsubscribed())  //TODO Comment uncomment this line and see output.
                    .forEach(subscriber::onNext);

            //takeWhile - GATE :: Once closed wont open
            //filter -> filters :: Open and close
        }

//        subscriber.onCompleted();
//        //Data channel is closed here, no data from here.
//        //Won't get Blah StockInfo
//        subscriber.onNext(new StockInfo("Blah", 0.0));
    }
}

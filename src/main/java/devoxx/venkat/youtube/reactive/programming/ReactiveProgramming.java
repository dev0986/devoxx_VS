package devoxx.venkat.youtube.reactive.programming;


//Reactive programmging -> Data flow computing
//Stream of data flowing towards us -> handle this data flow.

//rx-java -> Netflix for their Streaming issues.
//Akai - dealing with Streams

//Observable -> Push data when data is ready, Stream of data can come towards me.
//Iterator -> we pull data

//Data channel
//Error channel - Error flows as Data through the Error channel. 9Not second class citizens)
//Not mixing them together

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReactiveProgramming {

    public static void main(String[] args) {
        List<String> symbols =
                Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

        Observable<StockInfo> feed = StockServer.getFeed(symbols);

//        feed.subscribe(
//                System.out::println, //Data channel
//                System.out::println, //Error channel
//                () -> System.out.println("Done") //onComplete channel
//        );
        //Three implementations of Lambdas, we are sending 1 interface with concrete implementations.
        feed.subscribe(new Subscriber<StockInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("DONE");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("oops " + e);
            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);
                if (stockInfo.getTicker().equals("AAPL") && stockInfo.getPrice() > 100) {
                    System.out.println("Thanks, no more data..ready to trade");
                    unsubscribe();
                }
            }
        });

    }
}











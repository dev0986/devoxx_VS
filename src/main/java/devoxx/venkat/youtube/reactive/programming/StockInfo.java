package devoxx.venkat.youtube.reactive.programming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class StockInfo {

    private final String ticker;
    private final Double price;

}

package ll.j17.shaun.functional.programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// map only works with streams.
public class StreamMap {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));


        System.out.println(
                listOfIntegers.stream()
                        .map(StreamMap::timesTwo)
                        .collect(Collectors.toList())
        );

        Function<Integer, Integer> timesTwo = (a) -> a * 2;
        System.out.println(
                listOfIntegers.stream()
                        .map(timesTwo)
                        .collect(Collectors.toList())
        );

        System.out.println(
                listOfIntegers.stream()
                        .map(StreamMap::timesTwo)
                        .collect(Collectors.toList())
        );
    }

    private static int timesTwo(int x) {
        return x * 2;
    }


}

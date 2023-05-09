package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Characteristics
//sized OR unsized
//ordered OR unordered
//distinct OR non-distinct
//sorted OR unsorted
public class StreamCharacteristics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        // sized, ordered, non-distinct, non-sorted
//        numbers.stream()
//                .filter(e -> e % 2 == 0)
//                //.distinct() // change properties along the way.
//                //.sorted() // Change properties along the way.
//                .forEach(System.out::println);

        //Infinite Streams (unzised stream) Cannot exist without Laziness - side effects - immutability
        //System.out.println(Stream.iterate(100, e -> e + 1));
        // start with 100, create a series which is
        // 100, 101, 102, 103...

        // Given a number k..
        // and a count n, find the total of double
        // of n even numbers starting with k where sqrt each number > 20
        int k = 121;
        int n = 51;

        System.out.println(compute(k, n));
    }

    public static int compute(int k, int n) {
//        int result = 0;
//        int count = 0;
//        int index = k;
//        while (count < n) {
//            if (index % 2 == 0 && Math.sqrt(index) > 20) {
//                result += index * 2;
//                count++;
//            }
//            index++;
//        }
//        return result;
        return Stream.iterate(k, e -> e + 1)//unbounded, lazy
                .filter(e -> e % 2 == 0)//unbounded, lazy
                .filter(e -> Math.sqrt(e) > 20)//unbounded, lazy
                .mapToInt(e -> e * 2) // unbounded, lasy
                .limit(n) // bounded (sized), lazy
                .sum(); //eager evaluation
    }
}

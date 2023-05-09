package org.example;

import java.util.Arrays;
import java.util.List;

//Phone searching in auditorium
//1 person at a time - 100 effort + 100 units of time
//All together - 100 effort however 1 unit of time. (As all start
//searching at the same time)

public class StreamsMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        TimeIt.code(() -> System.out.println(
                //numbers.stream()
                numbers.parallelStream()
                .filter(e -> e % 2 == 0)
                .mapToInt(StreamsMain::compute)
                .sum()));

//        System.out.println(numbers.stream()
//                .filter(e -> e % 2 == 0)
//                //.mapToInt(e -> compute(e))
//                .mapToInt(StreamsMain::compute)
//                .sum());
    }

    public static int compute(int number) {
        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }
        //Assume this is time intensive
        return number * 2;
    }
}

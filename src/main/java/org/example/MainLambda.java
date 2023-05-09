package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MainLambda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //println is an instance method on System.out (not a static method)
//        numbers.forEach(e -> System.out.println(e));
//        numbers.forEach(System.out::println);
        //Method ref to an instance method


        //Argument to a static method
//        numbers.stream()
//               // .map(e -> String.valueOf(e))
//                //reference to a static method
//                .map(String::valueOf)
//                .forEach(System.out::println);


        numbers.stream()
                .map(e -> String.valueOf(e))
                //.map(e -> e.toString())
                .map(String::toString)
                .forEach(System.out::println);

        //external iterators # 1
        for (int i = 0; i < numbers.size(); i++) { //controlling the iteration
            //System.out.println(numbers.get(i));
        }

        //external iterator # 2
        for (int e : numbers) { //controlling the iteration
            //System.out.println(e);
        }

        //internal iterator
        //pass object to a functions vs calling a function using an object (polymorphism)
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                //System.out.print(integer);
            }
        });
        //Java 8 has type inference, finally,
        //hold your tweets, but only for lambda expressions
        //paranthesis is optional but only for one parameter lambdas.
        //numbers.forEach(e -> System.out.print(e));
        //Method reference
        //numbers.forEach(System.out::println);

        //While Lambdas are really cute, keep them that way.

        //Method references: Only when you want to pass what you get onto the next journey
        //No manipulation/ business logic


        System.out.println(numbers.stream().reduce(0, (total, e) -> Integer.sum(total, e)));

        //System.out.println(numbers.stream().reduce(Integer::sum));

        System.out.println(numbers.stream().map(String::valueOf)
                .reduce("", (carry, str) -> carry.concat(str)));

        System.out.println(numbers.stream().map(String::valueOf)
                .reduce("", String::concat));
        //Cannot use if data manipulation
        ///Cannot use if conflict between static vs instance methods


    }
}

package ll.j17.shaun.functional.programming.streams;

//Recursion
//Partial application
//Function composition

import ll.j17.shaun.functional.programming.TriFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedFunctional {

    public static void countDown(Integer x) {
        //Exit condition/ Stop condition -> infinite.
        if (x < 0) {
            System.out.println("Done!");
            return;
        }
        System.out.println(x);
        countDown(x - 1);
    }

    static void countUp(Integer x, Integer n) {
        if (x > n) {
            System.out.println("Done!");
            return;
        }
        System.out.println(x);
        countUp(x + 1, n);
    }

    public static void main(String[] args) {


        // countDown(10);
        // countUp(0, 10);
        // Partial application
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial = (x) -> (y, z) -> add.apply(x, y, z);
        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);
        //System.out.println(add5.apply(1, 3));


        //TODO Takes in 2 args fixed and adds a 3rd


        //Recursion
        //Composition
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;
        //Compose above 2 functions.
        //--> timesTwo and thenminusOne
        //Compose happens in reverse order than you expect.
        Function<Integer, Integer> timesTwoMinusOne =
                minusOne.compose(timesTwo);

        Function<Integer, Integer> timesTwoMinusOne1 =
                timesTwo.andThen(minusOne);

        //System.out.println(timesTwoMinusOne.apply(10));
        //System.out.println(timesTwoMinusOne1.apply(10));

        Chapter3Challenge1.Employee[] employeesArr = {
                new Chapter3Challenge1.Employee("John", 34, "developer", 80000f),
                new Chapter3Challenge1.Employee("Hannah", 24, "developer", 95000f),
                new Chapter3Challenge1.Employee("Bart", 50, "sales executive", 100000f),
                new Chapter3Challenge1.Employee("Sophie", 49, "construction worker", 40000f),
                new Chapter3Challenge1.Employee("Darren", 38, "writer", 50000f),
                new Chapter3Challenge1.Employee("Nancy", 29, "developer", 75000f),
        };
        List<Chapter3Challenge1.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        //Get Employee names in reverse and uppercase
        Function<Chapter3Challenge1.Employee, String> capitalizeName = str -> str.name.toUpperCase();
        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();

        Function<Chapter3Challenge1.Employee, String> capitalizeAndReverseName = capitalizeName.andThen(reverse);

        System.out.println(
                employees.stream()
                        .map(capitalizeAndReverseName)
                        .collect(Collectors.toList())
        );


    }
}

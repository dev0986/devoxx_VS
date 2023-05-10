package ll.j17.shaun.functional.programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter2Video2 {

    public static void main(String[] args) {
        // 1 argument
        Function<Integer, Integer> absoluteValue = (x) -> x < 0 ? -x : x;
        System.out.println(absoluteValue.apply(10));

        // 2 arguments
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 30));

        // 3 arguments, Custom interface
        TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;
        System.out.println(triFunction.apply(1, 2, 3));

        //0 Arguments, Custom interface
        NoArgsfunction<String> noArgsfunction = () -> "Hello World";
        System.out.println(noArgsfunction.apply());
    }
}

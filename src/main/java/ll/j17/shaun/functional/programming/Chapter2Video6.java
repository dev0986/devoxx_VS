package ll.j17.shaun.functional.programming;

import java.util.function.BiFunction;
import java.util.function.Function;

// Higher order functions
public class Chapter2Video6 {

    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

//        BiFunction<Float, Float, Float> divideWithCheck = (x, y) -> {
//            if (y == 0.0f) {
//                throw new IllegalArgumentException("Divisor cannot be 0");
//            }
//            return x / y;
//        };

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>>
                secondArgIsntZeroCheck = (func) -> (x, y) -> {
            if (y == 0.0f) {
                throw new IllegalArgumentException("Divisor cannot be 0");
            }
            return func.apply(x, y);
        };


        BiFunction<Float, Float, Float> divideSafe
                = secondArgIsntZeroCheck.apply(divide);

        System.out.println(divideSafe.apply(10.00f,0.111f));

    }
}

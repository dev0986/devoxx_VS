package ll.j17.shaun.functional.programming;

import java.util.function.BiFunction;

//Passing Functions as Arguments
public class Chapter2Video4 {

    protected static class MyMath {
        //  4 Functions which take in 2 values and return a value.
        //  add(), subtract(), max(), min()
        public static Integer add(Integer a, Integer b) {
            return a + b;
        }

        public static Integer subtract(Integer a, Integer b) {
            return a - b;
        }

        public static Integer max(Integer a, Integer b) {
            return Math.max(a, b);
        }

        public static Integer min(Integer a, Integer b) {
            return Math.min(a, b);
        }

        public static Integer combine(Integer a, Integer b, BiFunction<Integer, Integer, Integer> combineFunction) {
            return combineFunction.apply(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(MyMath.combine(1, 2, MyMath::add));
        System.out.println(MyMath.combine(2, 3, MyMath::subtract));
        System.out.println(MyMath.combine(2, 3, MyMath::max));
        System.out.println(MyMath.combine(2, 3, MyMath::min));
        System.out.println(MyMath.combine(1, 2, (a, b) -> 2 * (a + b)));
    }
}

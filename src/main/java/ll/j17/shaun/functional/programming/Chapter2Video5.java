package ll.j17.shaun.functional.programming;


import java.util.function.Function;

//Return Functions from other Functions.
public class Chapter2Video5 {


    protected static class MyMath {
        public static Integer timesTwo(Integer number) {
            return number * 2;
        }

        public static Integer timesThree(Integer number) {
            return number * 3;
        }

        public static Integer timesFour(Integer number) {
            return number * 4;
        }

        //Can be used instead of the above 3 functions.
        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (x) -> x * y;
        }
    }

    public static void main(String[] args) {
        NoArgsfunction<NoArgsfunction<String>> creatorGreeter =
                () -> () -> "Hello function";
        //Function returning a Function that return a String.
        NoArgsfunction<String> greeter = creatorGreeter.apply();
        System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
        Function<Integer, Integer> timeFour = MyMath.createMultiplier(4);

        System.out.println(
                timesTwo.apply(10) + " - " +
                        timesThree.apply(10) + " - " +
                        timeFour.apply(10)

        );


    }


}

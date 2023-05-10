package ll.j17.shaun.functional.programming;


//Closure

import java.util.function.Function;

public class ClosureMain {


    public static void main(String[] args) {
        NoArgsfunction<NoArgsfunction<String>> createGreeter = () -> {
            String name = "Shaun";
            return () -> "Hello, " + name;
        };

        NoArgsfunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());

        //TODO ->
//        Function<Integer, Function<Integer, Integer>> function = (a,b) ->{
//            Integer x = 10;
//            return (m, n) -> m + n;
//        };
    }
}

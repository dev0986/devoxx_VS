package ll.j17.shaun.functional.programming;


//Closure

public class ClosureMain {


    public static void main(String[] args) {
        ll.j17.shaun.functional.programming.NoArgsfunction<ll.j17.shaun.functional.programming.NoArgsfunction<String>> createGreeter = () -> {
            String name = "Shaun";
            return () -> "Hello, " + name;
        };

        ll.j17.shaun.functional.programming.NoArgsfunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());

        //TODO ->
//        Function<Integer, Function<Integer, Integer>> function = (a,b) ->{
//            Integer x = 10;
//            return (m, n) -> m + n;
//        };
    }
}

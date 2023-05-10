package ll.j17.shaun.functional.programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));


        Function<Integer, Predicate<String>> createLengthTest = (x) -> {
            return (str) -> str.length() > x; // Predicate
            //return predicate;
        };

        //String[] names = {"Atish","Parth","Dinesh","Varun","Mayuri","Radhika","Prathitha","Shruti"};
        List<String> names = Arrays.asList("Atish", "Parth", "Dinesh", "Varun", "Mayuri", "Radhika", "Prathitha", "Shruti");

        Predicate<String> isLongerThan3 = createLengthTest.apply(3);
        Predicate<String> isLongerThan8 = createLengthTest.apply(8);

        System.out.println(
                names.stream()
                        .filter(isLongerThan3)
                        .collect(Collectors.toList())
                        + "\n" +
               names.stream()
                        .filter(isLongerThan8)
                        .collect(Collectors.toList())
        );

        System.out.println(
                // function.apply(5).test("Atish")
        );


//        System.out.println(
//                listOfIntegers.stream()
//                        .filter(e -> e % 2 == 0)
//                        .collect(Collectors.toList())
//        );
//
//        Predicate<Integer> isEvenPredicate = (x) -> (x % 2 == 0);
//        System.out.println(
//                listOfIntegers.stream()
//                        .filter(isEvenPredicate)
//                        .collect(Collectors.toList())
//        );
//
//        System.out.println(
//                listOfIntegers.stream()
//                        .filter(StreamFilter::isEven)
//                        .collect(Collectors.toList())
//        );
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }


}

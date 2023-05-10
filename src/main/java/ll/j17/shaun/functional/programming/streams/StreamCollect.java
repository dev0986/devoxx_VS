package ll.j17.shaun.functional.programming.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//  .collect()
//  Diff between reduce and collect
//  Reduce: Reducing a list of integers will give you an integer
//  Collect: No such restrictions.
//Java provides many Collectors.
public class StreamCollect {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Atish", "Apple", "Parth", "Dinesh", "Varun", "Mayuri", "Radhika", "Prathitha", "Shruti");

        List<String> longWords = names
                .stream()
                .filter(str -> str.length() > 6)
                .collect(Collectors.toList());
        longWords.forEach(System.out::println);

        System.out.println(
                names
                        .stream()
                        .filter(e -> e.length() > 2)
                        .collect(Collectors.joining(", "))
        );

        //Converts List of items into a String separated by the delimiter mentioned.
        String str = names
                .stream()
                .filter(e -> e.length() > 2)
                .collect(Collectors.joining(", "));
        System.out.println("Str: " + str);

        //counting -> returns a Long of how many elements meeting the criteria.
        Long howManyLongwords = null;
        System.out.println(
                names
                        .stream()
                        .filter(e -> e.length() > 2)
                        .collect(Collectors.counting())
        );

        //GroupingBy - Groups into multiple buckets based on the Function definition.
        Map<Integer, List<String>> wordLengthMap =
                names
                        .stream()
                        .collect(Collectors.groupingBy(
                                string -> string.length()
                        ));
        System.out.println(wordLengthMap);

        //PartitionBy - Similar to groupingBy but only 2 buckets (Predicate)
        Predicate<String> stringPredicate = (charSeq) -> charSeq.length() > 5;
        System.out.println(
                names
                        .stream()
                        .collect(
                                Collectors.partitioningBy(stringPredicate)
                        )
        );


    }
}

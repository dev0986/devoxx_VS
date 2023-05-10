package ll.j17.shaun.functional.programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ParallelStreams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Atish", "Apple", "Parth", "Dinesh", "Varun", "Mayuri", "Radhika", "Prathitha", "Shruti", "Dinesh", "Varun", "Mayuri", "Radhika", "Prathitha", "Shruti");

        names.parallelStream()
                .map(e -> {
                    System.out.println("to upper case");
                    return e.toUpperCase(Locale.ROOT);
                })
                .map(e -> {
                    System.out.println("Adding exclamation");
                    return e + "!";
                })
                .collect(Collectors.toList());
    }
}

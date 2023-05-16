package devoxx.venkat.youtube.Collectors;

import org.example.Person;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollecMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                Person.builder().age(10).name("Atish").build(),
                Person.builder().age(23).name("Disha").build(),
                Person.builder().age(43).name("Arti").build(),
                Person.builder().age(16).name("Ramya").build(),
                Person.builder().age(87).name("Prathitha").build(),
                Person.builder().age(45).name("Arjun").build()

        );

        //Map of name as Key and age as value
        System.out.println(
                people.stream()
                        //toMap(keyfunction, valueFunction)
                        .collect(Collectors.toMap(
                                person -> person.getName(),
                                person -> person.getAge()
                        ))
        );

        System.out.println(
                people.stream()
                        //toMap(keyfunction, valueFunction)
                        .collect(Collectors.toMap(
                                Person::getName,
                                Person::getAge
                        ))
        );


        //List of all age values
        System.out.println(
                people
                        .stream()
                        .map(p -> p.getAge())
                        .collect(Collectors.toList())
        );
//        List<Integer> ages = people
//                .stream()
//                .map(p -> p.getAge())
//                .collect(Collectors.toUnmodifiableList());
        // If
        //Immutability broken
//        ages.add(1000);
//        System.out.println(ages);

        // Create a comma separated the names in upper case
        // of people older than 30

        System.out.println(
                people
                        .stream()
                        .filter(p -> p.getAge() > 30)
                        .map(e -> e.getName())
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", "))
        );


        //Partioning

        //




















        //Immutability
        //Map of name as key and List of names as values

    }
}

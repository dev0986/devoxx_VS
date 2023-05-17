package devoxx.venkat.youtube.Collectors;

import org.example.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollecMain2 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                Person.builder().age(10).gender(Person.Gender.MALE).name("Atish").build(),
                Person.builder().age(23).gender(Person.Gender.FEMALE).name("Disha").build(),
                Person.builder().age(43).gender(Person.Gender.MALE).name("Arti").build(),
                Person.builder().age(16).gender(Person.Gender.MALE).name("Ramya").build(),
                Person.builder().age(87).gender(Person.Gender.NON_BINARY).name("Prathitha").build(),
                Person.builder().age(45).gender(Person.Gender.MALE).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.MALE).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.THEM).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.THEY).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.THEM).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.NON_BINARY).name("Arjun").build(),
                Person.builder().age(45).gender(Person.Gender.MALE).name("Arjun").build()

        );

        //Partition
        //Even age people, Odd age people
        Predicate<Integer> ageGtTn30Predicate = age -> age > 30;
        System.out.println(
                people
                        .stream()
                        .collect(Collectors.partitioningBy(
                                person -> person.getAge() % 2 == 0,
                                Collectors.toList()
                        ))
        );

        //GroupingBy
        //Group people based on Gender

        //groupingBy(Function<T, R>) ==> Collector
        //groupingBy(Function<T, R>, Collector

        System.out.println(
                people
                        .stream()
                        .collect(groupingBy(
                                Person::getGender,
                                //TODO Important concept here
                                //Collector within Collector
                                //Transformation after bucket identificaiton
                                //Before putting object in
                                //Only putting age in, not Person object
                                mapping(
                                        Person::getAge,
                                        //toList()
                                        toSet()
                                )
                        ))
                //Collector(Function, Collector(Function , Collector)
        );

        //Counting
        System.out.println(
                people
                        .stream()
                        .collect(groupingBy(
                                Person::getGender,
                                counting()
                        ))
        );

        //collectingAndThen applies a Collector and then a Function
        //Collector here is counting()
        //Function here is Long::intValue
        Map<Person.Gender, Integer> map = people
                .stream()
                .collect(groupingBy(
                        Person::getGender,
                        collectingAndThen(
                               counting(), //Collector
                               Long::intValue // Transformation before putting into bucket.
                        )
                ));

        // groupingBy and mapping (Function, Collector)
        // collectingAndThen      (Collector, Function)

    }
}

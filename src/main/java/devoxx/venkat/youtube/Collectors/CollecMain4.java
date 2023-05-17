package devoxx.venkat.youtube.Collectors;

import org.example.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//Exception handling is an imperative style of programing concept.

//In Functional Programming, we deal with a Stream of data/ data flow essentially.
//Deal with it downstream, SAFELY.
//Exception handling makes zero sense in FP, blow up your stack.
//Deal with errors not exceptions.
//Reactive library - data, error, complete channels

public class CollecMain4 {

    public static void main(String[] args) {

        Optional<String> string = Optional.of("");
        System.out.println(string.orElse("Disha"));
        List<Person> people = Arrays.asList(
                Person.builder().age(10).name("Atish").build(),
                Person.builder().age(20).name("Disha").build(),
                Person.builder().age(30).name("Arti").build(),
                Person.builder().age(30).name("Ramya").build(),
                Person.builder().age(50).name("Prathitha").build(),
                Person.builder().age(60).name("Arjun").build(),
                Person.builder().age(123).name("Karthik").build()
        );

//        System.out.println( people.stream()
//                .map(p -> p.getName())
//                .flatMap(n -> Stream.of(n.split("")))
//                .collect(Collectors.toList())
//        );

        System.out.println(
                people.stream()
                .collect(groupingBy(Person::getAge,
                                flatMapping(
                                        person -> Stream.of(person.getName().split("")),
                                        Collectors.toSet())))
        );

        //Performed mapping in middle of groupingBy
        //flatMapping when mapping

        System.out.println(
                "ddDdd: " +
                people.stream()
                        .collect(groupingBy(Person::getAge,
                                mapping(person -> person.getName().toUpperCase(Locale.CANADA),
                                        flatMapping(
                                                name -> Stream.of(name.split("")), toSet()))))
        );

        // flatMap, map, filtering -> Collectors


        //reduce - sum, max, min ,reduce, collect
        //collect - (Collector)
        //Collector
        //toList, toMap, toSet
        //toUnModifiableList, Set, Map
        //partitioningBy -> boolean
        //groupingBy - generalized partitioningBy
        //groupingBy(function<T,R>, Collector)
        //mapping(function, Collector)
        //collectingAndThen(Collector, function)
        //teeing(Collecrtor, Collector, Operator










    }
}

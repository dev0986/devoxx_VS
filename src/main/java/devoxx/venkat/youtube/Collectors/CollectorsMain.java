package devoxx.venkat.youtube.Collectors;

import org.example.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CollectorsMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                Person.builder().age(10).name("Atish").build(),
                Person.builder().age(23).name("Disha").build(),
                Person.builder().age(43).name("Arti").build(),
                Person.builder().age(16).name("Ramya").build(),
                Person.builder().age(87).name("Prathitha").build(),
                Person.builder().age(45).name("Atish").build()

        );

        System.out.println(
                people
                        .stream() // Eager to Lazy evaluation
                        //.filter(e -> e.getAge() > 30)
                        .map(Person::getAge)
                        //.reduce(0, (total, age) -> total + age)
                        .reduce(0, Integer::sum)
                        .intValue()
        );
        //Reduce takes Collection reduces to single value.
        //Reduce converts a Stream to something concrete.

        //Java has `reduce` in 2 forms:
        //reduce and collect -> collect is a reduce operation.
        //Lazy evaluations requires purity of function.

        // Pure function returnsd the same result any
        // number of times we call it with the same input
        // Idempotency
        //Pure functions -> don't have side effects

        //1. Pure functions do not change anything
        //2. Pure functions do not depend on anything
        // that may possibly change.

        System.out.println(
                people.stream()
                        .filter(e -> e.getAge() > 30)
                        .map(e -> e.getName().toUpperCase(Locale.CANADA))
                        .collect(Collectors.toList())
        );

        List<String> namesOfPeopleAbove30 = new ArrayList<>();

        //Don't do this
        people.stream()
                .filter(e -> e.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                //This is an impure function
                .forEach(name -> namesOfPeopleAbove30.add(name));
        //Mutating - Shared mutability.

        System.out.println(
                people.stream()
                        .filter(e -> e.getAge() > 30)
                        .map(Person::getName)
                        .map(String::toUpperCase)
                        //This is an impure function
                        .reduce(
                                new ArrayList<String>(),
                                (names, name) -> {
                                    names.add(name);
                                    // Mutable but no side effects.
                                    // Local Mutability, not changing a shared variable
                                    return names;
                                },
                                (names1, names2) -> {
                                    names1.addAll(names2);
                                    return names1;
                                }
                        )
        );


        System.out.println(namesOfPeopleAbove30);

        System.out.println(
                people.stream()
                        .filter(e -> e.getAge() > 30)
                        .map(Person::getName)
                        .map(String::toUpperCase)
                        //This is an impure function
                        .collect(Collectors.toList())
        );



    }
}

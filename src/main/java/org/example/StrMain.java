package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

//streams == Non mutating pipeline and pure abstraction

/*
filter: 0 <= number of elements in the output <= number of input
//parameter: Stream<T> filter takes in Predicate<T>

//map
// Transforms values
// Number of input == number of output
// No guarantee on the type of output with respect to the type of input
//parameter: Stream<T> maps takes Function<T, R> to produce Stream<R>

//reduce cuts across swim lanes
//Reduce<T> takes 2 parameters:
//first: is of Type T
//second: of type BiFunction<R, T> to produce Result of R.

//Both filter and map stay within their swim lane
        filter                  map                 reduce (cuts across swim lane)
                                                initial val: 0.0
--------------------------------------------        \
x1       pass                                        \
--------------------------------------------          \
                                                       +
                                                         \
x2      filter out              X2`                       \+
--------------------------------------------
x3      pass
--------------------------------------------
x4      filter out              X4`
--------------------------------------------





 */


public class StrMain {
    public static void main(String[] args) {
        //pipeline of transformations
        //not mutating.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        TimeIt.code(() -> System.out.println(
//                //numbers.stream()
//                numbers.parallelStream()
//                        .filter(e -> e % 2 == 0)
//                        .reduce(0, (carry, e) -> carry + e)));

        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;


//        System.out.println(numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .reduce(1, binaryOperator)
//        );
        //sum - reduce operation
        //brings values together
        //reduce cuts across swim lane
        //reduce transform collection into single value/ non stream/ concrete pipe.


        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        //double the even values and put that into a List
        //Wrong way
        List<Integer> doubleOfEven = new ArrayList();

        numbersList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e));

        //Mutability is Okay, sharing is nice, shared mutability is devil's work.
        //System.out.println(doubleOfEven); //Don't do this.
        //Friends don't let friends do shared mutation.

        List<Integer> doubleOfEven1 = numbersList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toList());
        //System.out.println(doubleOfEven1);

        Set<Integer> set = numbersList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toSet());
        //System.out.println(set);
        //collect is a reduce set as well.

        //Map of values
        List<Person> people = createPeople();
        //Create a map with name and age as key and person as value
        System.out.println(
                people.stream()
                        .collect(toMap(
                                person -> person.getName() + "-" + person.getAge(),
                                person -> person
                        ))
        );

        System.out.println(
                people.stream()
                        .collect(toMap(
                                person -> person.getAge(),
                                //Interesting output
                                //{32=java.util.function.Function$$Lambda$34/0x0000000800c4dbe8@1fb3ebeb,...}
                                person -> Function.identity()
                        ))
        );

        //Grouping By
        //Given a list of people, create a map where
        //their name is the key and value is all the people with that name.
        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName)));


        //Grouping and mapping
        //Given a list of people, create a map where
        //their name is the key and value is all ages of people with that name.
        System.out.println(
                people.stream()
                        .collect(
                                groupingBy(Person::getName,
                                mapping(Person::getAge, toList()))));

    }

    private static List<Person> createPeople() {
        return Arrays.asList(
                Person.builder().name("Sarah").gender(Person.Gender.FEMALE).age(30).build(),
                Person.builder().name("Bob").gender(Person.Gender.MALE).age(13).build(),
                Person.builder().name("Bob").gender(Person.Gender.MALE).age(40).build(),
                Person.builder().name("Bob").gender(Person.Gender.MALE).age(45).build(),
                Person.builder().name("Shruti").gender(Person.Gender.FEMALE).age(67).build(),
                Person.builder().name("Amita").gender(Person.Gender.FEMALE).age(32).build(),
                Person.builder().name("Sarah").gender(Person.Gender.FEMALE).age(12).build(),
                Person.builder().name("Abhishek").gender(Person.Gender.MALE).age(1).build(),
                Person.builder().name("Varsha").gender(Person.Gender.FEMALE).age(3).build()

        );

    }
}

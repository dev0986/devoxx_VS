package devoxx.venkat.youtube.Collectors;

import org.example.Person;

import java.util.Arrays;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;


public class CollectPostInterval {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                Person.builder().age(10).name("Atish").build(),
                Person.builder().age(20).name("Disha").build(),
                Person.builder().age(30).name("Arti").build(),
                Person.builder().age(30).name("Ramya").build(),
                Person.builder().age(50).name("Prathitha").build(),
                Person.builder().age(60).name("Arjun").build(),
                Person.builder().age(123).name("Karthik").build()
        );

        //flatMap
        List<Integer> numbers = List.of(1, 2, 3);
        //one-to-one function
        //Stream<T>.map<F1-1) --> Stream<R>
//        numbers.stream()
//                .map(e -> e * 2) //one-to-one function
//                .collect(toList());


        //one-to-many function
        //Stream<T>.map<F1-n) --> Stream<List<R>>
        System.out.println("one to many.map: " +
                numbers.stream()
                        .map(e -> List.of(e - 1, e + 2)) //one-to-many function
                        .collect(toList())
        );

        //flatMap
        //1-M function
        //Stream<T>.flatMap(f1N) ==> Stream<R> Not Stream<List<R>>

        //flapMap => mapFlatten (Kotlin example) map first, then flatten
        System.out.println("one to many.flatMap: " +
                numbers.stream()
                        .flatMap(e -> List.of(e - 1, e + 2).stream()) //one-to-many function
                        .collect(toList())
        );

//        Stream
//                .map(Function<T,R>) == Stream<R>
//                .flatMap(function<T,List<R>, Set<R> Stream<R>>) == Stream<R>

        //Moral:
        //If you have one to one Function, use map to go from: Stream<T> to Streamn<R>
        //If you have 1 to many Function, use map to go from: Stream<T> to Stream<Collection<R>>
        //If you have 1 to many Function, use flatMap to go from: Stream<T> to Stream<R>

        //flatMap vs flatMapping
        //for inside for, collection inside collection -> flat structure


        //TODO teeing try
        //teeing
        //combine two collectors together

        //grouping, mapping (Function, Collector)
        //collectingAndThen (Collector, Function)
        //teeing (Collector, Collector, Operation (BiOperation))


        //Filtering
        //TODO Important on map
        //map vs mapping
        //mapping -> when you want to transform in the middle of reduce
        System.out.println(
                people
                        .stream()
                        .collect(groupingBy(Person::getAge,
                                        mapping(Person::getName, toList()
                                        )
                                )
                        )
        );

        //filter vs filtering
        //middle of reduce, can perform filter
        //filtering in the middle of reduce !!!
        System.out.println(
                people
                        .stream()
                        .collect(groupingBy(Person::getAge,
                                mapping(Person::getName, filtering(name -> name.length() > 4, toList()))))
        );


        //System.out.println(210/6);
//        System.out.println("--" + people
//                .stream()
//                .map(e -> e.getAge())
//                .reduce(Integer::sum));

        //collectAndThen  applies a Collector and then a Function.
        String maxAge = people.stream()
                .collect(collectingAndThen(
                                maxBy(comparing(Person::getAge)),
                                person -> person.map(Person::getName).orElse("")
                        )
                );
        System.out.println("maxAge: " + maxAge);

        // Second
        String minAge = people.stream()
                .collect(collectingAndThen(
                                minBy(comparing(Person::getAge)),
                                person -> person.map(Person::getName).orElse("")
                        )
                );
        System.out.println("Min age: " + minAge);

        //210 total Age
        Integer averageAge = people.stream()
                .collect(collectingAndThen(
                                averagingInt(x -> x.getAge().intValue()),
                                aDouble -> aDouble.intValue()
                                //minBy(comparing(Person::getAge)),
                                //person -> person.map(Person::getName).orElse("")
                        )
                );
        System.out.println("Average age: " + averageAge);


        //List<String> list = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList))

        //Oldest Person in collection

        //Person with largest age
//        System.out.println(
//                "max age" + people
//                        .stream()
//                        .collect
//                                (maxBy(Comparator
//                                        .comparing(Person::getAge)))
//
//
//        );

//        System.out.println(
//                "min age:" + people
//                        .stream()
//                        .collect(Collectors
//                                .minBy(Comparator.comparing(Person::getAge))
//
//
//                        ));

        people.stream()
                .map(Person::getAge)
                .reduce(0, (total, age) -> total + age);

        //System.out.println(
        people.stream()
                .mapToInt(Person::getAge)
                .min();
        //);


        //reduce - reduce, collect, sum, min takes form of reduce
    }
}

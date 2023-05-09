package org.self.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(Person.builder().name("Atish").age(34).build());
        persons.add(Person.builder().name("Disha").age(98).build());
        persons.add(Person.builder().name("Shruti").age(45).build());
        persons.add(Person.builder().name("Zen").age(12).build());


        Predicate predicate = (str) -> str.equals("Atish");
        System.out.println(
                persons.stream()
                        .filter(e -> e.getAge() > 20)
                        .map(e-> e.getName())
                        //.filter(e -> e.length() > 4)
                        .anyMatch((str) -> str.equalsIgnoreCase("atish")
                )
        );




    }


}

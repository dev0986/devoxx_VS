package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Person {

    private String name;
    private Gender gender;
    private int age;

    enum Gender {
        MALE, FEMALE;

    }
}

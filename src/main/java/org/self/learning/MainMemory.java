package org.self.learning;

public class MainMemory {

    public static void main(String[] args) {

        for(int i = 0; i < 10000; i++){
            System.out.println(Employee.builder().build().getClass().descriptorString());

        }

    }
}

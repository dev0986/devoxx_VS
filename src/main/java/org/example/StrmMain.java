package org.example;

import java.util.Arrays;
import java.util.List;

public class StrmMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 4, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 178, 19, 20);

        //Imperative
        int result = 0;
        for (int e : numbers) {
            // TODO short circuit && condition... IMPORTANT
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        //System.out.println(result);
        //How much work? 8 units of work (not equal units)

        //Given an unordered list, find the double of the first even number > 3
//        numbers.stream().sorted()
//                .filter(StrmMain::isGT3) // 20 values
//                .filter(StrmMain::isEven) //17 values
//                .map(StrmMain::doubleIt)// 9 values
//                .findFirst();// 1 value
//        //20 + 17 + 9 = 46 units (NOT the case)
//        System.out.println("Done");

        //Doesnt do any work... Only done is sysout... none of the private method sysouts.
        numbers.stream()
                .filter(StrmMain::isEven)
                .filter(StrmMain::isGT3)
                .map(StrmMain::doubleIt);
        System.out.println("Done...");

        // You are more efficient not when you work faster
        // but when you don't work at all.
        // Lazy evaluations is possible only if the functions don't have
        // side effects. 9dont print stuff like in this example)
    }

    //LAZY computations.// Efficient computations.
    //Intermediate operations (postponed for evaluation) vs Terminal operations.

    //All operations on 1 elements of the Stream.
    private static boolean isGT3(int number) {
    //        System.out.println("isGT3: " + number);
        return number > 3;
    }

    private static boolean isEven(int number) {
    //        System.out.println("isEven: " + number);
        return number % 2 == 0;
    }

    private static int doubleIt(int number) {
    //        System.out.println("doubleIt: " + number);
        return number * 2;
    }
}

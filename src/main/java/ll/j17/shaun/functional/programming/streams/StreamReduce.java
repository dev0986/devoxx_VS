package ll.j17.shaun.functional.programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class StreamReduce {
    //Consumer<String> consumer = x -> x.length();
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> nums = new ArrayList<>(Arrays.asList(intArray));

        //Reduce


        int resultReduce = nums.stream().reduce(0, Integer::max);
        //System.out.println(resultReduce);

        Optional<Integer> resultOne = nums.stream().reduce(Integer::sum);
        //Returns Optional element, if we dont provide a starting value

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };


        System.out.println(
                nums
                        .stream()
                        .reduce(0, getSum)
        );
    }
}

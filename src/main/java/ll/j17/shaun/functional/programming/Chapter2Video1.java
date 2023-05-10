package ll.j17.shaun.functional.programming;

import java.util.function.Function;

public class Chapter2Video1 {

    protected static class MyMath {
        public static Integer triple(Integer number) {
            return number * 3;
        }

        public static Integer returnMultiple(int x){
            return x * 10;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> myTriple = MyMath::triple;
        Function<Integer, Integer> myTen = MyMath::returnMultiple;
        System.out.println(myTriple.apply(10));
    }
}

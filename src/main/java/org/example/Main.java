package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//Invoked Dynamic
// When anonymous classes are used to implement Functional interfaces, .class files are created.
//Lambda usage for Functional interfaces implementation -> no .class/ anonymous classes created.
//No garbage collection extra.
public class Main {
    public static void main(String[] args) {

        //Function
        //name - not important
        //parameter list // Lambda expression
        //body
        // return type - can be inferred


        Thread lambdathread =
                new Thread(() ->
                        System.out.println("Hello world"));
        lambdathread.start();

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread...");
            }
        });
        th.start();

//        Thread th1 = new Thread();
//        th1.start();
        System.out.println("In main");

    }
}

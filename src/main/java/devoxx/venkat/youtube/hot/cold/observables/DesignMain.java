package devoxx.venkat.youtube.hot.cold.observables;

public class DesignMain {

    /*
    Designing Reactive systems:
    - Partition based on user location/ query
          Reactive Manifesto
        - Scalability through Elasticity
        - Loose coupling event driven
        - Responsiveness
        - Resilient
    - Sharding and replication
    - Failure as first class citizen
    - Not an all or nothing proposition
        - Network failures
        - Database failures
        - Provide redundancies across geographical locations
        - load related failures
    - BackPressues
    - Use Circuit breakers
    - Improverd performance using parallelization
    - CAP Theorem: Cant have all 3
            Consistent, Availability and Partition tolerance.
            Eventual Concsistency (~ 5 ms, ~1 sec), Availability and Partition tolerance.


        circuit breakers are very important // ESSENTIAL
        Resilience4j - SkipTheDishes Inc.
        RLO Team. -> Restaurant Live Orders.

        http://reactivemanifesto.org



     */

    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

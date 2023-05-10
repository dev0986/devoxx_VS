package ll.j17.shaun.functional.programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chapter3Video7 {
    public static void main(String[] args) {
        Chapter3Challenge1.Employee[] employeesArr = {
                new Chapter3Challenge1.Employee("John", 34, "developer", 80000f),
                new Chapter3Challenge1.Employee("Hannah", 24, "developer", 95000f),
                new Chapter3Challenge1.Employee("Bart", 50, "sales executive", 100000f),
                new Chapter3Challenge1.Employee("Sophie", 49, "construction worker", 40000f),
                new Chapter3Challenge1.Employee("Darren", 38, "writer", 50000f),
                new Chapter3Challenge1.Employee("Nancy", 29, "developer", 75000f),
        };
        List<Chapter3Challenge1.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));


        //Question: Map<jobTitle, averageSalaries>

        System.out.println(
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                e -> e.jobTitle
                        ))
        );
        Map<String, Float> averageSalariesForJobTitle =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                e -> e.jobTitle
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue()
                                        .stream()
                                        .map(emp -> emp.salary)
                                        .reduce(0f, (acc, x) -> (acc + x) / e.getValue().size())
                        ));
        System.out.println(averageSalariesForJobTitle);

        Map<String, Float> averageSalaries =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                e -> e.jobTitle
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue()
                                        .stream()
                                        .map(emp -> emp.salary)
                                        .reduce(0f, (acc, x) -> (acc + x) / e.getValue().size())
                        ));
        System.out.println(averageSalaries);


        Float totalDeveloperSalaries =
                employees
                        .stream()
                        .filter(emp -> emp.jobTitle.equals("developer"))
                        .map(emp -> emp.salary)
                        .reduce(0.0f, Float::sum);

        Long numberOfDevelopers = employees
                .stream()
                .filter(emp -> emp.jobTitle.equals("developer"))
                .collect(Collectors.counting());

        Float averageDeveloperSalary = totalDeveloperSalaries / numberOfDevelopers;
        System.out.println(averageDeveloperSalary);


    }
}

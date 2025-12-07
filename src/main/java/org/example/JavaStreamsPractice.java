package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreamsPractice {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 4, 4, 13, 24, 89, 3, 6, 8, 2, 9, 13, 89, 24, 45, 78, 11, 43, 56, 33, 77, 79, 35);
       /* List<Integer> oddNums = nums.stream()
                .filter(num -> num % 2 == 1)
                .collect(Collectors.toList());
        Long countOfOddNumbers = nums.stream()
                        .filter(num->num%2==1)
                                .count();
        System.out.println("=============ODD Numbers====================================");
        System.out.println("List of odd numbers in an array : " + oddNums);
        System.out.println("count of odd numbers in an array : "+ countOfOddNumbers);

        List<Integer> evenNums = nums.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        int countOfEvenNumbers = Math.toIntExact(nums.stream()
                .filter(num -> num % 2 == 0)
                .count());
        System.out.println("=============EVEN Numbers====================================");
        System.out.println("List of even numbers : " + evenNums);
        System.out.println("Count of even number in as array : " + countOfEvenNumbers);

        List<Integer> numbers = nums.stream()
                .filter(num -> num > 25)
                .collect(Collectors.toList());
        System.out.println("========Numbers bigger than 25================================");
        System.out.println("Numbers bigger than 25 : " + numbers);
        System.out.println("count of numbers bigger than 25 : " + Math.toIntExact(numbers.size()));

        List<Integer> numbs = nums.stream()
                .filter(num -> num <= 25)
                .collect(Collectors.toList());
        System.out.println("========Numbers smaller than 25================================");
        System.out.println("Numbers smaller than 25 : " + numbs);
        System.out.println("count of numbers smaller than 25 : " + Math.toIntExact(numbs.size()));


        List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4);

        int sums = listNumbers.stream()
                .map(num-> (num * num) )
                .reduce(0, Integer::sum);
        System.out.println(sums);


        List<Integer> heightNumbers= nums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top Three Highest numbers : "+ heightNumbers);*/

        int maxNumber = nums.stream()
                .max(Integer::compare)
                .get();
        System.out.println("Max number : " + maxNumber);

        List<Integer> distinctNums = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(distinctNums);


        Employee emp = new Employee(100, "kalesh", "prod", 10000);
        Employee emp1 = new Employee(101, "pavan", "qc", 20000);
        Employee emp2 = new Employee(102, "ramesh", "qc", 15000);
        Employee emp3 = new Employee(103, "prakash", "prod", 25000);

        List<Employee> empList = Arrays.asList(emp, emp1, emp2, emp3);

        empList.stream()
                .filter(employee -> employee.salary > 15000)
                .forEach(employee -> System.out.println(employee.id + ":" + employee.name + " : " + employee.salary + " : " + employee.dept));

        Map<String, List<Employee>> emplst = empList.stream()

                .collect(Collectors.groupingBy(employee -> employee.dept));


    }
}

class Employee {
    int id;
    String name;
    String dept;
    double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

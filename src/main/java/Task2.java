import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.groupingBy;

public class Task2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Pavel", 33, 12000.0, "Dev"),
                new Employee("Andrey", 23, 15000.0, "ENT"),
                new Employee("Ilya", 34, 125000.0, "Math"),
                new Employee("Stan", 31, 5000.0, "Dev"),
                new Employee("Ibrahim", 44, 2000.0, "ENT"),
                new Employee("Alena", 34, 8000.0, "Dev"),
                new Employee("Elena", 32, 88000.0, "Math"),
                new Employee("Mark", 25, 18000.0, "Math"),
                new Employee("Kiril", 52, 5000.0, "ENT"),
                new Employee("Anton", 53, 1500.0, "ENT"),
                new Employee("Stepan", 19, 10000.0, "Dev"),
                new Employee("Svetlana", 20, 60000.0, "Math"),
                new Employee("Maxim", 27, 3000.0, "Math"),
                new Employee("Fred", 60, 12500.0, "Dev"),
                new Employee("Azis", 31, 45000.0, "Dev")
        );

        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        employees.stream()
                .filter(item -> item.getSalary() <= 10000)
                .map(item -> item = new Employee(item.getName(), item.getAge(), SalaryRiser.modify(item), item.getDepartment()))
                .forEach(System.out::println);

        Map<String, List<Employee>> depToEmployees = employees.stream()
                .collect(groupingBy(Employee::getDepartment));

        System.out.println();
        System.out.println("Department - List<Employee>");

        printMap(depToEmployees);

        System.out.println();
        System.out.println("Department - avg salary");

        Map<String, Double> collect = employees.stream()
                .collect(groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        printMap(collect);
    }

    private static void printMap(Map<?, ?> mapToPrint) {
        for (Object key : mapToPrint.keySet()) {
            System.out.println(key);
            Object o = mapToPrint.get(key);
            if (o instanceof Collection) {
                for (Object object : (Collection<Object>) o) {
                    System.out.println(object);
                }
            } else System.out.println(o);
        }
    }
}


class SalaryRiser {
    public static double modify(Employee employee) {
        double salary = employee.getSalary();
        double twenty = salary / 5;
        return salary + twenty;
    }
}

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee() {
    }

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

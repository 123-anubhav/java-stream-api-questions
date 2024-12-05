# java-stream-api-questions-logical
explanations for the logical questions using Java 8 Stream API:

---

# Logical Questions Using Java 8 Stream API

This project demonstrates how to solve various logical questions using the Java 8 Stream API. Below are examples using an `Employee` class.

## Employee Class
The `Employee` class represents an employee with properties such as ID, name, age, gender, department, year of joining, and salary.

```java
public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    // Constructor, getters, setters, and toString method
}
```

## Logical Questions

### 1. Initialize Employee Data

```java
public class Logical15Questions {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "amit yadav", 18, "male", "IT", 2000, 45458.00);
        Employee e2 = new Employee(2, "anubhav srivastava", 30, "male", "FULL STACK DEVELOPER", 2001, 45788.00);
        Employee e3 = new Employee(3, "ram srivastava", 24, "male", "MANAGER", 2018, 45968.70);
        Employee e4 = new Employee(4, "ramesh roy", 29, "male", "SALES", 2014, 7508.00);
        Employee e5 = new Employee(5, "shekhar sinha", 34, "male", "ENGINEER", 2012, 145458.00);
        Employee e6 = new Employee(6, "alok singh", 28, "male", "DEVOPS", 2002, 48458.00);
        Employee e7 = new Employee(7, "neha batham", 35, "female", "CLOUD ENGINEER", 2013, 55458.00);
        Employee e8 = new Employee(8, "shweta singh", 30, "female", "IT", 2007, 78958.00);
        Employee e9 = new Employee(9, "arpita singh", 35, "female", "HR", 2008, 78958.00);
        Employee e10 = new Employee(10, "dyna", 28, "female", "MANAGER", 2012, 45878.00);
        Employee e11 = new Employee(11, "ajay kumar", 32, "male", "IT SUPPORT", 2019, 36458.00);
        Employee e12 = new Employee(12, "prateek saxena", 26, "male", "DATA ANALYST", 2020, 50458.00);
        Employee e13 = new Employee(13, "rahul sharma", 27, "male", "SOFTWARE ENGINEER", 2012, 62458.00);
        Employee e14 = new Employee(14, "sunil deva", 18, "male", "DEVOPS", 2010, 154458.00);
        Employee e15 = new Employee(15, "rohit agarwal", 29, "male", "PROJECT MANAGER", 2014, 193458.00);
        Employee e16 = new Employee(16, "pooja mishra", 25, "female", "QUALITY ANALYST", 2009, 35458.00);
        Employee e17 = new Employee(17, "amit shukla", 31, "male", "MARKETING EXECUTIVE", 2008, 47458.00);
        Employee e18 = new Employee(18, "kavita jain", 36, "female", "TEAM LEAD", 2016, 85458.00);
        Employee e19 = new Employee(19, "vikas verma", 24, "male", "JUNIOR DEVELOPER", 2015, 28458.00);
        Employee e20 = new Employee(20, "sneha choudhary", 29, "female", "UI/UX DESIGNER", 2015, 49458.00);

        Stream<Employee> list = Stream.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20);
    }
}
```

### 2. Names Start with 'A'

```java
// Names starting with 'A'
list.filter(n -> n.getName().startsWith("a")).forEach(System.out::println);
```

### 3. Group by Department

```java
// Group employees by department
Map<String, List<Employee>> collect = list.collect(Collectors.groupingBy(Employee::getDepartment));
collect.forEach((dept, emp) -> System.out.println(dept + " - " + emp));
```

### 4. Count Male and Female Employees

```java
// Count male and female employees
Map<String, Long> collectGender = list.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
collectGender.forEach((gender, count) -> System.out.println(gender + " - " + count));
```

### 5. Print All Departments

```java
// Print all departments
List<String> listOfDept = list.map(Employee::getDepartment).distinct().collect(Collectors.toList());
listOfDept.forEach(System.out::println);
```

### 6. Average Age of Male and Female Employees

```java
// Average age of male and female employees
Map<String, Double> ageCollection = list.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
ageCollection.forEach((gender, averageAge) -> System.out.println(gender + " - " + averageAge));
```

### 7. Highest Paid Employee

```java
// Highest paid employee
Optional<Employee> highestPaidEmployee = list.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
highestPaidEmployee.ifPresent(System.out::println);
```

### 8. Employees Joined After 2015

```java
// Employees joined after 2015
List<Employee> joinAfter2015 = list.filter(joining -> joining.getYearOfJoining() > 2015).collect(Collectors.toList());
joinAfter2015.forEach(System.out::println);
```

### 9. Count Employees in Each Department

```java
// Count employees in each department
Map<String, Long> totalEmpOfEachDept = list.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
totalEmpOfEachDept.forEach((dept, count) -> System.out.println(dept + " - " + count));
```

### 10. Average Salary of Each Department

```java
// Average salary of each department
Map<String, Double> averageSalary = list.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
averageSalary.forEach((dept, avgSal) -> System.out.println(dept + " - " + avgSal));
```

### 11. Youngest Male Employee in DEVOPS

```java
// Youngest male employee in DEVOPS
Optional<Employee> youngestMaleEmpOfDevopsDept = list.filter(dept -> dept.getDepartment().equalsIgnoreCase("DEVOPS") && dept.getGender().equalsIgnoreCase("male")).min(Comparator.comparing(Employee::getAge));
youngestMaleEmpOfDevopsDept.ifPresent(System.out::println);
```

### 12. Most Experienced Employee

```java
// Most experienced employee
Optional<Employee> mostExpPerson = list.min(Comparator.comparing(Employee::getYearOfJoining));
mostExpPerson.ifPresent(System.out::println);
```

### 13. Male and Female Employees in DEVOPS and HR

```java
// Male and female employees in DEVOPS and HR
Map<String, Long> filteredData = list.filter(dept -> dept.getDepartment().equalsIgnoreCase("DEVOPS") || dept.getDepartment().equalsIgnoreCase("HR")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
filteredData.forEach((dept, totalCount) -> System.out.println(dept + " - " + totalCount));
```

### 14. Average Salary by Gender

```java
// Average salary by gender
Map<String, Double> avgSalByGender = list.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
avgSalByGender.forEach((gender, avgSal) -> System.out.println(gender + " - " + avgSal));
```

### 15. Names of Employees in Each Department

```java
// Names of employees in each department
Map<String, List<Employee>> empNamesByDept = list.collect(Collectors.groupingBy(Employee::getDepartment));
empNamesByDept.forEach((dept, emp) -> System.out.println(dept + " - " + emp));
```

### 16. Average and Total Salary of Organization

```java
// Average salary of the entire organization
Double avgSalOfOrg = list.collect(Collectors.averagingDouble(Employee::getSalary));
System.out.println("Average Salary of Organization: " + avgSalOfOrg);

// Total salary of the organization
Double totalSalary = list.mapToDouble(Employee::getSalary).sum();
System.out.println("Total Salary of Organization: " + totalSalary);
```

###

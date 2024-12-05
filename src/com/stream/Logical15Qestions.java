package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logical15Qestions {

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

		Stream<Employee> list = Stream.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20);
		
		/* OR BY THIS YOU CAN USE STREAM
		List<Employee> asList = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20);
		list.forEach(p->System.out.println(p));
		
		*/
		// NAMES START WITH 'A' lIST DATA
		// list.filter(n-> n.getName().startsWith("a") ).forEach(System.out::println);
		
		// GET DATA GROUP BY DEPARTMENT => RETURN [ DEPARTMENT WISE EMPLOYEE DATA ]
		/*Map<String,List<Employee>> collect = list.collect(Collectors.groupingBy(d->d.getDepartment()));
		collect.forEach((dept,emp)->System.out.println(dept+" - "+emp));
		*/
		
		/*
		// 1. How many male and female employees are there in the organization?   O/P    LIKE MALE -> 5, FEMALE -> 7
		Map<String,Long> collectGender = list.collect(Collectors.groupingBy(g->g.getGender(),Collectors.counting()));
		collectGender.forEach((gender,count)->System.out.println(gender+"-"+count));
	    */
		
		/*
		// OR USING METHOD REFERENCE OPERATOR :: CODE
		list.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
			.forEach((gender,count)->System.out.println(gender+"-"+count));
		
		*/
		/*
		// 2. Print the name of all departments in the organization.
			
		List<String> listOfDept = list.map(dept->dept.getDepartment()).distinct().collect(Collectors.toList());
		listOfDept.forEach(System.out::println);
		*/
		
		/*
		
		// 3. What is the average age of male and female employees? 
		Map<String, Double> ageCollection = list.collect(Collectors.groupingBy(g->g.getGender(),Collectors.averagingInt(a->a.getAge())));
		ageCollection.forEach((gender,averageAge)->System.out.println(gender+" - "+averageAge));
		*/
		
		/*
		// 	4. Get the details of the highest-paid employee in the organization.
		
	
		Optional<Employee> collect = list.collect(Collectors.maxBy(Comparator.comparingDouble(sal->sal.getSalary())));
		if(collect.isPresent()) {
			System.out.println("higest salary is :: "+collect.get());
		}
		*/	
		
		/*
		 * 
		// 5. Get the names of all employees who have joined after 2015.
		 
		List<Employee> joinAfter2015 = list.filter(joining->joining.getYearOfJoining() > 2015).collect(Collectors.toList());
		joinAfter2015.forEach(System.out::println);
		 */
		
		/*
		//  6. Count the number of employees in each department.
		 Map<String,Long> totalEmpOfEachDept = list.collect(Collectors.groupingBy(dept->dept.getDepartment(),Collectors.counting()));
		totalEmpOfEachDept.forEach((dept,count)->System.out.println(dept+" - "+count));
		*/
		
		/*
		 * //  7. What is the average salary of each department?
		
		Map<String, Double> averageSalary = list.collect(Collectors.groupingBy(dept->dept.getDepartment(),Collectors.averagingDouble(sal->sal.getSalary())));
		averageSalary.forEach((dept,avrgSalary)->System.out.println(dept+" - "+avrgSalary));
		 */
		
		/*
		 //  8. Get the details of the youngest male employee in the DEVOPS department.
					
	     Optional<Employee> youngestMaleEmpOfDevopsDept = list.filter( dept -> dept.getDepartment().equalsIgnoreCase("DEVOPS") &&
	     dept.getGender().equalsIgnoreCase("male")) .min(Comparator.comparing(Employee::getAge ));
		
	     if(youngestMaleEmpOfDevopsDept.isPresent()) {
	    	 System.out.println("youngest emp is :: - "+youngestMaleEmpOfDevopsDept.get());
	     }
				  	 */
	
		/*
		 // 9. Who has the most working experience in the organization?
		 * */
		Optional<Employee> mostExpPerson = list.min(Comparator.comparing(Employee::getYearOfJoining));
		if(mostExpPerson.isPresent()) {
			System.out.println(" most experience person in our organization is :: "+mostExpPerson.get());
		}
		
		/*
		 // 10. How many male and female employees are there in the DEVOPS and HR DEPT ? 

		Map<String,Long> filteredData = list.filter(dept->dept.getDepartment().equalsIgnoreCase("devops")||dept.getDepartment().equalsIgnoreCase("hr"))
		    .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
		filteredData.forEach((dept,totalCount)->System.out.println(dept+"  ::  "+totalCount));
		 */
	}
}

package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class logicalQ {

	public static void main(String[] args) {

		/*
		 * (1)
		 * 
		 * List<Integer> asList = Arrays.asList(5, 78, 98, 56, 50, 565);
		 * 
		 * Stream<Integer> stream = asList.stream();
		 * 
		 * stream.forEach(i -> System.out.println(i));
		 */

		/*
		 * (2) List<String> list = Arrays.asList("INDIA", "CHINA", "USA", "UK",
		 * "MEXICO", "ENGLAND", "SRILANKA", "PAKISTAN");
		 * 
		 * List<String> collect = list.stream().filter(p ->
		 * p.equals("UK")).collect(Collectors.toList());
		 * 
		 * collect.forEach(i -> System.out.println(i));
		 */
		List<String> ui = Arrays.asList("NG", "REACT", "BOOTSTRAP", "CSS", "JS", "AJAX", "ES8", "JQUERY");

		// FOR THIS SCENARIO WE WILL USE FLATMAP
		/*
		 * List<String> ui = Arrays.asList("NG", "REACT", "BOOTSTRAP", "CSS", "JS",
		 * "AJAX", "ES8", "JQUERY"); List<String> backend = Arrays.asList("JAVA",
		 * ".NET", "PYTHON", "PHP");
		 * 
		 * Stream<List<String>> listOfList = Stream.of(ui, backend);
		 */
		/*
		 * (3) listOfList.forEach(i -> System.out.println(i));
		 */

		/*
		 * (4) Stream<String> flatMap = listOfList.flatMap(p -> p.stream());
		 * flatMap.forEach(print -> System.out.println(print));
		 */

		List<String> courses = Arrays.asList("BOOT", "ANGULAR", "REACT", "JAVA-8", "MYSQL");

		/*
		 * (5)
		 * 
		 * Optional<String> status1 = courses.stream().filter(p ->
		 * p.contains("REACT")).findAny();
		 * 
		 * if (status1.isPresent()) { System.out.println(status1); }
		 */

		/*
		 * (6)
		 * 
		 * // TERMINAL OPERATION
		 * 
		 * boolean anyMatch = courses.stream().anyMatch(i -> i.contains("MYSQL")); //
		 * true System.out.println("is any data found or not :: " + anyMatch);
		 * 
		 * boolean allMatch = courses.stream().allMatch(i -> i.contains("MYSQL")); //
		 * false System.out.println("is any data found or not :: " + allMatch);
		 * 
		 * boolean noneMatch = courses.stream().noneMatch(i -> i.contains("MYSQL")); //
		 * false System.out.println("is any data found or not :: " + noneMatch);
		 * 
		 * boolean noneMatch1 = courses.stream().noneMatch(i -> i.contains("PHP")); //
		 * true System.out.println("is any data found or not :: " + noneMatch1);
		 */

		/*
		 * (7)
		 * 
		 * 
		 * Optional<String> first = courses.stream().filter(p ->
		 * p.contains("BOOT")).findFirst(); if (first.isPresent()) {
		 * System.out.println(first.get()); }
		 */
		
		/*
		 * (8)
		 

		// INTERMEDIATE OPERATION
		courses.stream().map(i -> i.toLowerCase()).forEach(i -> System.out.println(i));
		* 
		 */
	}
}

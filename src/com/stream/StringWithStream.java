package com.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringWithStream {

	public static void main(String[] args) {

		/*
		 * String str = "ilovejavatechie"; String[] splitStr = str.split("");
		 */
		/*
		 * Stream<String> stream = Arrays.stream(splitStr); stream.forEach(s ->
		 * System.out.print(s));
		 */

		/*
		 * // 1. Java program to count the occurrence of each character in a string
		 * Map<String, Long> occurStrCount = Arrays.stream(splitStr)
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 * // Print character and count occurStrCount.forEach((character, count) ->
		 * System.out.println(character + " - " + count));
		 */

		/*
		 * // 2. Java program to find all duplicate element from a given string
		 * Map<String,List<String>> occurDuplicateStr=
		 * Arrays.stream(splitStr).collect(Collectors.groupingBy(s->s));
		 * occurDuplicateStr.forEach((character, count) -> System.out.println(character
		 * + " - " + count));
		 */

		// 11. Java program to find all non-repeat element from a given string

		/*
		 * Map<String, Long> occurStr = Arrays.stream(splitStr)
		 * .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
		 * Arrays.stream(splitStr).filter(f -> occurStr.get(f) == 1).forEach(p ->
		 * System.out.print(p + ", "));
		 */

		// 3.i) Java program to find first non-repeat element from a given string
		/*
		 * Map<String, Long> occur1stStr = Arrays.stream(splitStr)
		 * .collect(Collectors.groupingBy(p -> p, Collectors.counting())); // to check
		 * what we are receiving
		 * occur1stStr.forEach((p,q)->System.out.print(p+" -> "+q+" ,"));
		 */
		/*
		 * Optional<String> first = Arrays.stream(splitStr).filter(p->
		 * occur1stStr.get(p)==1).findFirst(); if(first.isPresent()) {
		 * System.out.println("\nfirst non repeat character in given string is :: "
		 * +first.get()); }
		 */

		/*
		 * 3.ii) Java program to find second non-repeat element from a given string
		 * Optional<String> secondNonRepeatChar = Arrays.stream(splitStr).filter(p->
		 * occur1stStr.get(p)==1).skip(1).findFirst();
		 * System.out.println("\nsecond Non Repeat Character is :: "+secondNonRepeatChar
		 * .get());
		 */

		// 4. Java program to find 2nd highest number from given array
		int[] numbers = { 5, 9, 11, 2, 8, 21, 29, 1 };

		// boxing int[] to Integer because stream is not work in primitive data type
		// like int, float
		Stream<Integer> boxedData = IntStream.of(numbers).boxed();

		/*
		 * // sort array code in reverse order Stream<Integer> sortedArr =
		 * boxedData.sorted(Collections.reverseOrder());
		 * 
		 * // to check sorting works or not //
		 * sortedArr.forEach(p->System.out.println(p));
		 * 
		 * Optional<Integer> secondHighestNumber = sortedArr.skip(1).findFirst(); if
		 * (secondHighestNumber.isPresent()) {
		 * System.out.println("2nd highest number is :: " + secondHighestNumber); }
		 * 
		 */
		/*
		 * // for finding 1st highest number Optional<Integer> firstHighestNumber =
		 * sortedArr.findFirst(); if (firstHighestNumber.isPresent()) {
		 * System.out.println("1st highest number is :: " + firstHighestNumber); }
		 */
		/*
		 * // for finding 3rd highest number Optional<Integer> thirdHighestNumber =
		 * sortedArr.skip(2).findFirst(); System.out.println("2nd highest number is :: "
		 * + thirdHighestNumber.get());
		 */

		/*
		 * // for sorting number data System.out.println("sorted number are :: ");
		 * boxedData.sorted().forEach(System.out::println);
		 */

		/*
		 * 1ST WAY TO DO THIS QUESTION // 4.iv) // for finding 3rd lowest number
		 * Optional<Integer> thirdLowestNumber = boxedData.sorted().skip(2).findFirst();
		 * System.out.println("third lowest number is :: "+thirdLowestNumber);
		 * 
		 * 
		 * // 2nd WAY TO DO THIS QUESTION List<Integer> collect =
		 * boxedData.sorted().collect(Collectors.toList());
		 * System.out.println(" third lowest number is :: "+collect.get(2));
		 */

		/*
		// 6. Java program to find all elements from array who starts with 1

		// Convert the int[] to List<Integer>
		List<Integer> collect = IntStream.of(numbers).boxed().collect(Collectors.toList());

		// Convert each element to a String and filter those starting with "2"
		collect.stream().map(String::valueOf) // Convert each Integer to a String
				.filter(p -> p.startsWith("2")) // Filter elements starting with "2"
				.forEach(System.out::println); // Print each element
		 */
		
		 // 5. Java program to find longest string from given array
		String[] strArray={"php","techie","springboot","microservices"};
		Optional<String> max = Stream.of(strArray).max(Comparator.comparing(String::length));
		System.out.println(max.get());
		
		
		// 5.i) Java program to find smallest string from given array
		System.out.println("smallest length string in given data is :: "+Stream.of(strArray).min(Comparator.comparing(String::length)).get());
		
		// 5.ii) Java program to find 2nd smallest string from given array
		System.out.println("2nd smallest length string in given data is :: "+
								Stream.of(strArray)
									  .sorted(Comparator.comparing(String::length))
									  .skip(1)
									  .findFirst()
									  .get());
		
		// 5.iii) Java program to find 2nd longest string from given array
		String[] strArray1={"php","c#",".net","aws"};

        // Find the 2nd longest string by length
        String secondLongest = Stream.of(strArray1)
            .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())) // Sort in descending order by length
            .skip(1) // Skip the longest string (first element)
            .findFirst() // Get the 2nd longest
            .orElse(null); // Handle cases where there are fewer than 2 strings

        // Output the result
        if (secondLongest != null) {
            System.out.println("Second longest string: " + secondLongest);
        } else {
            System.out.println("Array does not have enough elements.");
        }
	}
}

String with Stream Api java 8 Questions

---

# Java Stream API Examples

This project demonstrates various logical problems solved using the Java 8 Stream API. Below are examples and explanations.

## Code Examples

### Initialize Stream and Print Elements
```java
package com.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StreamExamples {
    public static void main(String[] args) {

        // Example 1: Split and Print String
        String str = "ilovejavatechie";
        String[] splitStr = str.split("");
        Stream<String> stream = Arrays.stream(splitStr);
        stream.forEach(s -> System.out.print(s));
        
        // Example 2: Count Occurrences of Each Character in a String
        Map<String, Long> occurStrCount = Arrays.stream(splitStr)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurStrCount.forEach((character, count) -> System.out.println(character + " - " + count));
        
        // Example 3: Find All Duplicate Elements in a String
        Map<String, List<String>> occurDuplicateStr = Arrays.stream(splitStr)
            .collect(Collectors.groupingBy(s -> s));
        occurDuplicateStr.forEach((character, count) -> System.out.println(character + " - " + count));
        
        // Example 4: Find All Non-Repeat Elements in a String
        Map<String, Long> occurStr = Arrays.stream(splitStr)
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Arrays.stream(splitStr)
            .filter(f -> occurStr.get(f) == 1)
            .forEach(p -> System.out.print(p + ", "));
        
        // Example 5: Find First Non-Repeat Element in a String
        Map<String, Long> occur1stStr = Arrays.stream(splitStr)
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Optional<String> first = Arrays.stream(splitStr)
            .filter(p -> occur1stStr.get(p) == 1)
            .findFirst();
        first.ifPresent(s -> System.out.println("\nFirst non-repeat character: " + s));
        
        // Example 6: Find Second Non-Repeat Element in a String
        Optional<String> secondNonRepeatChar = Arrays.stream(splitStr)
            .filter(p -> occur1stStr.get(p) == 1)
            .skip(1)
            .findFirst();
        secondNonRepeatChar.ifPresent(s -> System.out.println("Second non-repeat character: " + s));
        
        // Example 7: Find Second Highest Number in Array
        int[] numbers = {5, 9, 11, 2, 8, 21, 29, 1};
        Stream<Integer> boxedData = IntStream.of(numbers).boxed();
        Optional<Integer> secondHighestNumber = boxedData
            .sorted(Collections.reverseOrder())
            .skip(1)
            .findFirst();
        secondHighestNumber.ifPresent(s -> System.out.println("Second highest number: " + s));
        
        // Example 8: Find Elements from Array that Start with 1
        List<Integer> collect = IntStream.of(numbers).boxed().collect(Collectors.toList());
        collect.stream()
            .map(String::valueOf)
            .filter(p -> p.startsWith("2"))
            .forEach(System.out::println);
        
        // Example 9: Find Longest String in Array
        String[] strArray = {"php", "techie", "springboot", "microservices"};
        Optional<String> max = Stream.of(strArray)
            .max(Comparator.comparing(String::length));
        max.ifPresent(s -> System.out.println("Longest string: " + s));
        
        // Example 10: Find Smallest String in Array
        Optional<String> min = Stream.of(strArray)
            .min(Comparator.comparing(String::length));
        min.ifPresent(s -> System.out.println("Smallest string: " + s));
        
        // Example 11: Find Second Smallest String in Array
        Optional<String> secondSmallest = Stream.of(strArray)
            .sorted(Comparator.comparing(String::length))
            .skip(1)
            .findFirst();
        secondSmallest.ifPresent(s -> System.out.println("Second smallest string: " + s));
        
        // Example 12: Find Second Longest String in Array
        String[] strArray1 = {"php", "c#", ".net", "aws"};
        String secondLongest = Stream.of(strArray1)
            .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
            .skip(1)
            .findFirst()
            .orElse(null);
        
        if (secondLongest != null) {
            System.out.println("Second longest string: " + secondLongest);
        } else {
            System.out.println("Array does not have enough elements.");
        }
    }
}
```

## Detailed Explanations

### 1. Split and Print String
Splitting a string into individual characters and printing them.

### 2. Count Occurrences of Each Character in a String
Using `Collectors.groupingBy` to count the frequency of each character.

### 3. Find All Duplicate Elements in a String
Grouping characters and identifying duplicates.

### 4. Find All Non-Repeat Elements in a String
Filtering characters that appear only once.

### 5. Find First Non-Repeat Element in a String
Finding the first character that does not repeat.

### 6. Find Second Non-Repeat Element in a String
Finding the second character that does not repeat.

### 7. Find Second Highest Number in Array
Sorting the array in reverse order and finding the second highest number.

### 8. Find Elements from Array that Start with 1
Filtering numbers that start with the digit '1'.

### 9. Find Longest String in Array
Finding the string with the maximum length.

### 10. Find Smallest String in Array
Finding the string with the minimum length.

### 11. Find Second Smallest String in Array
Finding the second smallest string by length.

### 12. Find Second Longest String in Array
Finding the second longest string by length.

---

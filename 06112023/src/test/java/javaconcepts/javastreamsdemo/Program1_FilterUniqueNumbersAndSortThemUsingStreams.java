package javaconcepts.javastreamsdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program1_FilterUniqueNumbersAndSortThemUsingStreams {

	public static void main(String[] args) {

		List<Integer> numbersList = Arrays.asList(1, 90, 100, 2);

		// Print Unique numbers sorted in ascending order
		numbersList.stream().distinct().sorted().forEach(n -> System.out.print(n + " ")); // 1 2 90 100

		List<Integer> output = numbersList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(output.get(4)); //100

		//
	}
}

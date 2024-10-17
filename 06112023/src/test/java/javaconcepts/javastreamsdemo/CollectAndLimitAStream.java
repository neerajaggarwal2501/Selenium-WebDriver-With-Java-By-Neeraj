package javaconcepts.javastreamsdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CollectAndLimitAStream {

	@Test
	public void tc001() {
		List<String> list1 = Stream.of("India", "Japan", "China", "Canada", "Dubai").filter(s -> s.endsWith("a")).collect(Collectors.toList());
		System.out.println(list1); //[India, China, Canada]

		List<String> list2 = Stream.of("India", "Japan", "China", "Canada", "Dubai").filter(s -> s.endsWith("a")).limit(1).collect(Collectors.toList());
		System.out.println(list2); //[India]
	}
}

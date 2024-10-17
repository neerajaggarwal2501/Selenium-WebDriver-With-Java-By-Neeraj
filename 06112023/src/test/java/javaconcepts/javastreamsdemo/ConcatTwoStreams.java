package javaconcepts.javastreamsdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class ConcatTwoStreams {

	@Test
	public void tc001() {
		List<String> list1 = Arrays.asList("a", "y");
		List<String> list2 = Arrays.asList("b", "z");

		Stream<String> s1 = list1.stream();
		Stream<String> s2 = list2.stream();

		Stream<String> outputStream = Stream.concat(s1, s2);
		
		outputStream.sorted().forEach(s -> System.out.println(s)); // a b y z
	}

}

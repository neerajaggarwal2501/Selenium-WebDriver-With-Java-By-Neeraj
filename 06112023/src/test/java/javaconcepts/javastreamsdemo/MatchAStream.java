package javaconcepts.javastreamsdemo;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatchAStream {

	// https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html

	@Test
	public void filterAStream() {
		// Count the number of names which starts with a
		List<String> list1 = Arrays.asList("a", "y");

		boolean flag = list1.stream().anyMatch(s -> s.equalsIgnoreCase("A"));
		Assert.assertTrue(flag);

	}
}

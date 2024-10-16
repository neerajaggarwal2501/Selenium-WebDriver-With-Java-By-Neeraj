package javaconcepts.javastreamsdemo;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class FilterArrayListUsingStreamsAndLambdaFunction {

	// https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html

	@Test
	public void filterAStream() {
		// Count the number of names which starts with a
		List<String> names = new ArrayList<String>();
		names.add("Anu");
		names.add("Ann");
		names.add("Sunrise");
		names.add("John");
		names.add("Ashu");

		// Approach 1
		long count1 = names.stream().filter(name -> name.startsWith("A")).count(); // No impact on names. count is executed in the end

		// Approach 2
		long count2 = names.stream().filter(name -> {
			if (name.startsWith("A"))
				return true;
			else
				return false;
		}).count();

		assertEquals(count1, 3);
		assertEquals(count2, 3);
	}
}

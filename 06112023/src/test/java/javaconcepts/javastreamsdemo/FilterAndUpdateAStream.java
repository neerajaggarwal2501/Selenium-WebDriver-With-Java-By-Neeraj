package javaconcepts.javastreamsdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class FilterAndUpdateAStream {

	// https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html

	@Test
	public void StreamMapDemo() {
		// Count the number of names which starts with a
		List<String> names = new ArrayList<String>();
		names.add("Anthony");
		names.add("Anu");
		names.add("Sunrise");
		names.add("Ann");
		names.add("John");

		// Print names starting with A
		names.stream().filter(name -> name.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// ANTHONY
		// ANU
		// ANN

		System.out.println("\n\n");
		// Filter Names starting with A.Sort. Convert to upper Case. Print on Console.
		names.stream().filter(name -> name.startsWith("A")).sorted(Collections.reverseOrder()).map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));
		// ANU
		// ANTHONY
		// ANN
	}
}

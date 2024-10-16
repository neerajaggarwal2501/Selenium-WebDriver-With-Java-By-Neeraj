package utilities.javautilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

	public static void main(String[] args) {

		Path path = Path.of(System.getProperty("user.dir"), "target", "output.txt");

		try {
			String fileContent = Files.readString(path);
			System.out.println("\nContents of the file " + path.toString() + " are: \n" + fileContent);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFile {

	public static void main(String[] args) {
		String textToBeWrittenToFile = "Hello World!\nTest Passed.." ;
		Path path = Path.of(System.getProperty("user.dir"), "target", "output.txt");
		try {
			Files.writeString(path, textToBeWrittenToFile);
			System.out.println("Contents saved to file " + path.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package utilities;

public class StringUtilities {

	// The format string "%1$15s" do the job.
	// 1$ indicates the argument index,
	// s indicates that the argument is a String and 'length' represents the minimal width of the String. Putting it all together: "%1$15s".
	public static String formatAsAfixedLengthString(String string, int length) {
		return String.format("%1$" + length + "s", string);
	}

}

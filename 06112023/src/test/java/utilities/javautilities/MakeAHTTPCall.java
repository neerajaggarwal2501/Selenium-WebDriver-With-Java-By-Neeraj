package utilities.javautilities;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class MakeAHTTPCall {

	@Test
	public void tc001() throws MalformedURLException, IOException {
		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://github.com/neerajaggarwal2501").openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.connect();
		assertEquals(httpURLConnection.getResponseCode(), 200);
	}
}
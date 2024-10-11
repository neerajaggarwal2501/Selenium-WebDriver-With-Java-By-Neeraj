package demo.connecttoalreadyalreadyrunningbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ConnectToAlreadyRunningBrowser {

	// Launch Chrome browser using below command to connect automation to this existing Chrome browser
	// C:\Program Files\Google\Chrome\Application>chrome.exe --remote-debugging-port=9222 --user-data=d:\chromeData
	// C:\Program Files\Google\Chrome\Application>netstat -na | find "9222" |find "LISTENING"
	// TCP 127.0.0.1:9222 0.0.0.0:0 LISTENING
	// open google.com and observe that it's title is "Google"

	@Test
	public void tc001_ConnectToAlreadyRunningChromeBrowser() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("debuggerAddress", "localhost:9222"); // This port need to be same as mentioned above

		WebDriver driver = new ChromeDriver(chromeOptions);
		System.out.println(driver.getTitle()); // Verify that title is printed as "Google"
	}
}
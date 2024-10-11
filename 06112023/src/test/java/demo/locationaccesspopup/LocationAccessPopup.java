package demo.locationaccesspopup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class LocationAccessPopup {

	// doesn't show location access prompt C:\Program Files\Google\Chrome\Application>chrome --disable-notifications
	// --disable-notifications option is documented at https://github.com/GoogleChrome/chrome-launcher/blob/main/docs/chrome-flags-for-tools.md
	// This is a chromium feature. Hence is applicable for both Chrome and Edge browsers.

	@Test
	public void tc001_SuppressLocationAccessNotificationInChromeBrowser() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.spicejet.com/"); // Shows a PopUp which says that SpiceJet wants to access your location with options Access or Deny
		Thread.sleep(6000);
		driver.quit();
	}

	@Test
	public void tc002_SuppressLocationAccessNotificationInEdgeBrowser() throws InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();

		edgeOptions.addArguments("--disable-notifications");

		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(6000);
		driver.quit();
	}

	@Test
	public void tc003_SuppressLocationAccessNotificationInFirefoxBrowser() throws InterruptedException {

		// TBD
	}
}
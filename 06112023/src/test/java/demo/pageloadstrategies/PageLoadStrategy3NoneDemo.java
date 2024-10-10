package demo.pageloadstrategies;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageLoadStrategy3NoneDemo {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		//EdgeOptions edgeOptions = new EdgeOptions();
		//FirefoxOptions firefoxOptions = new FirefoxOptions();
		//SafariOptions safariOptions = new SafariOptions();
		
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		try {
			// Navigate to URL
			driver.get("https://google.com");
		} finally {
			driver.quit();
		}
	}
}
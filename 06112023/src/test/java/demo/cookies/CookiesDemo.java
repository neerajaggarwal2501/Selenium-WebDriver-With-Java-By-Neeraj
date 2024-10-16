package demo.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CookiesDemo {

	WebDriver driver;
	String app_url = "https://www.yahoo.com/";

	@Test
	public void tc001a_test_getCookieNamed() {
		driver = new ChromeDriver();
		driver.get(app_url);

		Cookie cookie = driver.manage().getCookieNamed("A1");
		System.out.println("\n\n" + cookie + "\n\n");
		driver.quit();
	}

	@Test
	public void tc001b_getCookies() {
		// Iteration 1
		driver = new ChromeDriver();
		driver.get(app_url);
		Set<Cookie> cookies1 = driver.manage().getCookies();

		int i = 0;
		System.out.println("\nIteration 1\n");
		for (Cookie cookie : cookies1) {
			System.out.println("[ " + ++i + " ] " + cookie.getName() + " : " + cookie.getValue() + " : " + cookie.getExpiry());
		}
		driver.quit();

		// Iteration 2
		driver = new ChromeDriver();
		driver.get(app_url);
		Set<Cookie> cookies2 = driver.manage().getCookies();

		int j = 0;
		System.out.println("\nIteration 2\n");
		for (Cookie c : cookies2) {
			System.out.println("[ " + ++j + " ] " + c.getName() + " : " + c.getValue() + " : " + c.getExpiry());
		}
		driver.quit();
	}

	@Test
	public void tc002a_test_deleteCookieNamed() {
		driver = new ChromeDriver();
		driver.get(app_url);

		System.out.println("\n\nCount of cookies before deleting the cookie name 'bcookie': " + driver.manage().getCookies().size());
		driver.manage().deleteCookieNamed("bcookie");
		System.out.println("\n\nCount of cookies after deleting the cookie named 'bcookie': " + driver.manage().getCookies().size());
		driver.quit();
	}

	@Test
	public void tc002b_test_deleteAllCookies() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(app_url);

		int i = 1;
		while (i < 30) {
			System.out.println("Count of cookies after " + String.format("%02d", i) + " seconds " + " :  " + driver.manage().getCookies().size());
			Thread.sleep(1000);
			i += 1;
		}

		System.out.println("Executed Deleted All Cookies command: \n");
		driver.manage().deleteAllCookies();
		i = 1;
		while (i < 30) {
			System.out.println("Count of cookies after " + String.format("%02d", i) + " seconds " + " :  " + driver.manage().getCookies().size());
			Thread.sleep(1000);
			i += 1;
		}
		System.out.println("\n\nCount of cookies after deleting all cookies: " + driver.manage().getCookies().size());
		driver.quit();
	}

	@Test
	public void tc003_test_addCookie() {
		driver = new ChromeDriver();
		driver.get(app_url);

		// Multiple constructors are available. Use the one, depending upon the values that need to be set.
		// More info about cookies could be found at https://www.w3.org/TR/webdriver1/#cookies
		// https://www.selenium.dev/documentation/webdriver/interactions/cookies/
		driver.manage().addCookie(new Cookie("key-1", "value-1"));
		driver.manage().addCookie(new Cookie("key-2", "value-2"));
		System.out.println("[Cookie Key-1] :" + driver.manage().getCookieNamed("key-1"));
		System.out.println("[Cookie Key-2] :" + driver.manage().getCookieNamed("key-2"));
		driver.manage().deleteAllCookies();
		System.out.println("\n[Currently stored Cookies] :" + driver.manage().getCookies());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

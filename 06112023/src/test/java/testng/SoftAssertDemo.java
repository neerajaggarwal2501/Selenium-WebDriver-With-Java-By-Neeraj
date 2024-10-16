package testng;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	WebDriver driver;

	@Test
	public void tc001_SoftAssertDemo() {
		driver = new ChromeDriver();
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "SoftAssertions.html");

		driver.get(application_path.toString());

		WebElement january = driver.findElement(By.xpath("((//table//tr)[2]/td)[2]"));
		WebElement february = driver.findElement(By.xpath("((//table//tr)[3]/td)[2]"));
		WebElement march = driver.findElement(By.xpath("((//table//tr)[4]/td)[2]"));
		WebElement april = driver.findElement(By.xpath("((//table//tr)[5]/td)[2]"));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(january.getText(), "January");
		softAssert.assertEquals(february.getText(), "February");
		softAssert.assertEquals(march.getText(), "March");
		softAssert.assertEquals(april.getText(), "April");
		softAssert.assertAll();
		//Output
//		FAILED: testng.SoftAssertDemo.tc001_SoftAssertDemo
//		java.lang.AssertionError: The following asserts failed:
//			expected [February] but found [FebruaryABC],
//			expected [March] but found [MarchPQR]
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

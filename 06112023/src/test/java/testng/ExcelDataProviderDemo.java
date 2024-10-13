package testng;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apachepoi.ReadExcel;

public class ExcelDataProviderDemo {

	WebDriver driver;

	@DataProvider(name = "test-data")
	public Object[][] dataProvFunc() throws IOException {
		String[][] dataProvider = ReadExcel.excelDataProvider("ExcelDataProviderDemo.xlsx", "title", true);
		System.out.println(Arrays.deepToString(dataProvider));
		return dataProvider;
	}

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "test-data")
	public void tc001(String url, String expectedTitle) throws IOException, InterruptedException {

		driver.get(url);

		Thread.sleep(2000);
		assertEquals(driver.getTitle(), expectedTitle);

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}

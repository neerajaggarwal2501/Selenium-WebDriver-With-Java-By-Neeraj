package javaconcepts.javastreamsdemo;

import java.nio.file.Path;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Program2_ValidateThatTableIsSortedUsingStreams {

	@Test
	public void test() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "SortableTable.html");

		driver.get(application_path.toString());

		Thread.sleep(2000);

		WebElement table_header_Country = driver.findElement(By.xpath("//th[text()='Country']"));
		table_header_Country.click(); // This will sort by Country in Ascending order

		// 1
		System.out.println("Clicked on table header named Country");
		List<WebElement> countriesList = driver.findElements(By.xpath("//table//tr/td[1]"));
		List<String> actualListOfCountries = countriesList.stream().map(s -> s.getText()).toList();

		List<String> expectedListOfCountries = actualListOfCountries.stream().sorted().toList();
		Assert.assertEquals(actualListOfCountries, expectedListOfCountries);

		// 2 Print the Capital of India
		countriesList.stream().filter(s -> s.getText().equals("India")).map(s -> getCapital(s)).forEach(s -> System.out.println(s));// New Delhi

		driver.quit();
	}

	private static String getCapital(WebElement Country) {
		return Country.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}

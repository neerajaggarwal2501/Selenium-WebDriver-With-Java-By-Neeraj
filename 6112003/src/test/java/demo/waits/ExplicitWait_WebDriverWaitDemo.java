package demo.waits;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_WebDriverWaitDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		// Explicit Wait types (WebDriverWait , FluentWait). Here we are implementing WebDriverWait.
		// 15 seconds specified here is the max waiting time. The actual waiting time is the time in which the specified condition is met.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));   //---->Explicit Wait or WebDriverWait Line 1

		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "Wait.html");

		driver.get(application_path.toString());

		Date d1 = new Date();
		driver.findElement(By.id("Question_India")).click();

		// In this example, the driver will continuously check if the element is clickable
		// When the element is clickable (i.e. after 5 seconds). Driver will read it's text
		// move to next execution step.
		WebElement capitalOfIndia = wait.until(ExpectedConditions.elementToBeClickable(By.id("Answer_India_Delhi")));  //---->Explicit Wait or WebDriverWait Line 1
		Date d2 = new Date();
		System.out.println(d1 + "  " + d2 + " " + capitalOfIndia.getText() + "  " );

		// The driver will continuously check if the element is clickable
		// When the element is clickable (i.e. after 10 seconds). Driver will read it's text
		// and move to next execution step.
		Date d3 = new Date();
		driver.findElement(By.id("Question_Japan")).click();
		WebElement capitalOfJapan = wait.until(ExpectedConditions.elementToBeClickable(By.id("Answer_Japan_Tokyo")));
		Date d4 = new Date();
		System.out.println(d3 + "  " + d4 + " " + capitalOfJapan.getText() + "  " );

		driver.quit();
	}
}
package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickUsingActionsClassDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/test/resources/Click.html");

		Actions actions = new Actions(driver);

		WebElement button = driver.findElement(By.id("Question_India"));
		Thread.sleep(3000);
		actions.click(button).perform();
		driver.quit();
	}
}
package demo.actionclassdemo;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemoUsingActionsClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "DoubleClick.html");

		driver.get(application_path.toString());
		Actions actions = new Actions(driver);

		// Locate the textbox
		WebElement textBox = driver.findElement(By.xpath("//input"));
		Thread.sleep(4000);
		actions.doubleClick(textBox).perform();
		Thread.sleep(4000);
		driver.quit();
	}
}
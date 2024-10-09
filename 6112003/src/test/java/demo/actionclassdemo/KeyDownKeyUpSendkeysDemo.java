package demo.actionclassdemo;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDownKeyUpSendkeysDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources",
				"KeyBoardActions.html");

		driver.get(application_path.toString());

		WebElement txtBox1 = driver.findElement(By.xpath("//input[@id='fruit1']"));
		Actions actions = new Actions(driver);
		// Ctrl + A
		Thread.sleep(500);
		actions.keyDown(txtBox1, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		// Ctrl +C
		Thread.sleep(500);
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		// Press and Unpress the TAB key
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).perform();
		// Press ctrl +V
		Thread.sleep(500);
		actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

		Thread.sleep(5000);
		driver.quit();
	}
}
package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDownKeyUpSendkeysDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/KeyBoardActions.html");
		WebElement txtBox1 = driver.findElement(By.xpath("//input[@id='fruit1']"));
		WebElement txtBox2 = driver.findElement(By.xpath("//input[@id='fruit2']"));
		Actions actions = new Actions(driver);
		//Ctrl + A
		Thread.sleep(500);
		actions.keyDown(txtBox1, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		//Ctrl +C
		Thread.sleep(500);
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		//Press and Unpress the TAB key
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).perform();
		//Press ctrl +V
		Thread.sleep(500);
		actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
	}
}
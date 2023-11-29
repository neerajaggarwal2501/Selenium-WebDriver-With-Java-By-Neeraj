package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemoUsingActionsClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/DoubleClick.html");
		Actions actions = new Actions(driver);

		//Locate the textbox
		WebElement textBox = driver.findElement(By.xpath("//input"));
		Thread.sleep(4000);
		actions.doubleClick(textBox).perform();
		
	}
}
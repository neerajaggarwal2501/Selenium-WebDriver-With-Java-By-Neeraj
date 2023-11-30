package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/RightClick.html");
		
		Actions actions = new Actions(driver);
		
		WebElement textBox = driver.findElement(By.xpath("//input"));
		
		Thread.sleep(2000);
		
		actions.contextClick(textBox).perform();

	}
}
package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemousingActionsClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/MouseHover.html");
		
		Actions actions = new Actions(driver);
		
		//Locate button 1 and button2
		WebElement button1 = driver.findElement(By.xpath("//button[1]"));
		WebElement button2 = driver.findElement(By.xpath("//button[2]"));
		
		//perform mouse hover
		actions.moveToElement(button1).perform();
		Thread.sleep(2000);
		actions.moveToElement(button2).perform();
		
	}
}
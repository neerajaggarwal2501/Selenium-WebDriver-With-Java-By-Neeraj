package demo.actionclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemoUsingActionsClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/DragAndDrop.html");
		Actions actions = new Actions(driver);
		
		//Source
		WebElement source_Apple = driver.findElement(By.id("Source_Apple"));
		WebElement source_Mango = driver.findElement(By.id("Source_Mango"));
		WebElement source_Orange = driver.findElement(By.id("Source_Orange"));
		//Target
		WebElement target_Apple = driver.findElement(By.id("Target_Apple"));
		WebElement target_Mango = driver.findElement(By.id("Target_Mango"));
		WebElement target_Orange = driver.findElement(By.id("Target_Orange"));
		
		//Perform drag and drop
		actions.dragAndDrop(source_Apple, target_Apple).perform();
		actions.dragAndDrop(source_Mango, target_Mango).perform();
		actions.dragAndDrop(source_Orange, target_Orange).perform();

		
	}

}

package demo.javascriptexecutorinterfacedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorInterfaceDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/Click.html");
		
		//Getting the JavaScript Executor
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		WebElement button1 = driver.findElement(By.id("Question_India"));
		Thread.sleep(3000);
		
		//Perform Button click using JavaScriptExecutor 
		jsExecutor.executeScript("document.getElementById('Question_India').click()");   // Call JSExecutor by passing 1 argument
		Thread.sleep(3000);

		//Reload the page using JavaScriptExecutor
		jsExecutor.executeScript("location.reload()"); 
		Thread.sleep(3000);
		
		//Since we have refreshed the page, 
		//so we need to find element again or else we will throw exception :- "StaleElementReferenceException"
		button1 = driver.findElement(By.id("Question_India"));  
		
		//Perform Button click using JavaScriptExecutor
		jsExecutor.executeScript("arguments[0].click();",button1);	// Call JSExecutor by passing multiple arguments
	}
}
package demo.iframedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleIframeDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/iframe/IFrame.html");

		Thread.sleep(3000);
//		driver.switchTo().frame(0);   		// by index
//		driver.switchTo().frame("India"); 	// By name
//		driver.switchTo().frame("IN"); 		// by id
		WebElement frame_India = driver.findElement(By.id("IN"));  	// by WebElement
		driver.switchTo().frame(frame_India); 				    	// by WebElement
		driver.findElement(By.id("Question_India")).click();

		driver.switchTo().parentFrame();
		driver.switchTo().frame("JP"); // 4
		driver.findElement(By.id("Question_Japan")).click();

	}
}
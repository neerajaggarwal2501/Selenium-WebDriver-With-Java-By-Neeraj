package demo.iframedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeNestedDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/iframe/IFrame_Nested.html");
		
		Thread.sleep(3000);
		driver.switchTo().frame("frame2");
		driver.switchTo().frame("IN");
		driver.findElement(By.id("Question_India")).click();
	}
}
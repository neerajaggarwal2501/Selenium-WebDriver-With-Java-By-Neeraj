package demo.waits;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExplicitWait_FluentWaitDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(1L))
			       .ignoring(NoSuchElementException.class);
		
		driver.get("file:///C://Users//NeerajAggarwal//eclipse-workspace//6112003//src//test//resources//Wait.html");
		
		//1
		driver.findElement(By.id("Question_India")).click();
		
		System.out.println("Question 1 Clicked " + new Date());
		wait.until(ExpectedConditions. elementToBeClickable(By.id("Answer_India_Delhi")));  // FluentWait Added . Max waiting time is 30 sec. interval = 1 sec
		System.out.println("Answer 1 available" + new Date());
		
		WebElement answer1 = driver.findElement(By.id("Answer_India_Delhi"));
		System.out.println(answer1.getText());    // 
		
		//2
		driver.findElement(By.id("Question_Japan")).click();
		
		System.out.println("Question 2 Clicked " + new Date());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Answer_Japan_Tokyo")));  // FluentWait Added . Max waiting time is 30 sec. interval = 1 sec
		System.out.println("Answer 2 available" + new Date());
		
		WebElement answer2 = driver.findElement(By.id("Answer_Japan_Tokyo"));
		System.out.println(answer2.getText()); //
		
	}

}

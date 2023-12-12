package demo.iframedemo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IframeDemo {
	public static void main(String[] args) throws InterruptedException {
		String file_path = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "IframeDemo.html";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		
		
		driver.get(file_path);
		
		driver.switchTo().frame("frame1");
		//In the DropDown, default selection is 'Volvo'. Select 'Audi' from drop down.
		Select select = new Select(driver.findElement(By.id("cars")));
		System.out.println("sleeping for 5 seconds"); Thread.sleep(5000);
		select.selectByValue("audi");
		System.out.println("sleeping for 3 seconds"); Thread.sleep(5000);
		
		driver.switchTo().parentFrame();
		
		//Switch to frame 2 and click the button with the label "Show Answer"
		driver.switchTo().frame("frameTwo");
		driver.findElement(By.id("Question_India")).click();
	}
}
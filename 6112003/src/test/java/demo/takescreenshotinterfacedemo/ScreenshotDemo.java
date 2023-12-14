package demo.takescreenshotinterfacedemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/DragAndDrop.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		
		// Full Screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile.toPath(), Paths.get(System.getProperty("user.dir"),"screenshots",scrFile.getName()));

		// Screenshot of a WebElement - button1
		WebElement button1 = driver.findElement(By.xpath("//button[@id='Source_Apple']"));
		File scrFile1 = ((TakesScreenshot) button1).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile1.toPath(), Paths.get(System.getProperty("user.dir"),"screenshots",scrFile1.getName()));

		Thread.sleep(2000);
		driver.quit();
	}

}

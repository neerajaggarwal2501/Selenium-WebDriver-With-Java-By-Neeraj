package demo.takescreenshotinterfacedemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Path sourcePath = screenshotFile.toPath();
		Path destinationPath = Paths.get(System.getProperty("user.dir"),"screenshots",screenshotFile.getName());
		Files.copy(sourcePath, destinationPath);

		System.out.println("[Full Page] Source Path      :"  + sourcePath);
		System.out.println("[Full Page] Destination Path :"  + destinationPath);
		

		// Screenshot of a WebElement - button1
		WebElement button_Apple = driver.findElement(By.id("Source_Apple"));
		File screenshotFile1 = ((TakesScreenshot) button_Apple).getScreenshotAs(OutputType.FILE);
		Path sourcePath1 = screenshotFile1.toPath();
		Path destinationPath1 = Paths.get(System.getProperty("user.dir"),"screenshots",screenshotFile1.getName());
		Files.copy(sourcePath1, destinationPath1);

		System.out.println("[WebElement] Source Path      :"  + sourcePath1);
		System.out.println("[WebElement] Destination Path :"  + destinationPath1);


		Thread.sleep(2000);
		driver.quit();
	}

}

package demo.javascriptexecutorinterfacedemo;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorInterfaceDemo2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "ScrollBars.html");

		driver.get(application_path.toString());

		// Element 1 - Vertical scroll
		WebElement button_30_KG_KIWI = driver.findElement(By.xpath("//button[text()='30 KG Kiwi']"));

		// Getting the JavaScript Executor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		Thread.sleep(2000);

		// Move to an element that requires horizontal as well as vertical scroll
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", button_30_KG_KIWI);

		Thread.sleep(5000);
		driver.quit();
	}
}
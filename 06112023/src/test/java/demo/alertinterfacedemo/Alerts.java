package demo.alertinterfacedemo;

import java.nio.file.Path;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Path application_path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "JavaScriptPopupBoxes.html");

		driver.get(application_path.toString());

		WebElement button1 = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		WebElement button2 = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		WebElement button3 = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
		
		button1.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());    		//1
		Thread.sleep(3000);
		alert1.accept();								//2
	
		button2.click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert2.getText());			//1
		alert2.accept();								//2
		
		button2.click();
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert3.getText());			//1
		alert3.dismiss();								//3
		
		button3.click();
		Alert alert4 = driver.switchTo().alert();
		System.out.println(alert4.getText());
		Thread.sleep(2000);
		alert4.sendKeys("Mickey Mouse");				//4
		alert4.accept();								//2

		Thread.sleep(5000);
		driver.quit();
	
	}
}
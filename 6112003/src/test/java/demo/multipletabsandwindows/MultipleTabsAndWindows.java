package demo.multipletabsandwindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsAndWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		//Print the handle
		String handle1 = driver.getWindowHandle();			//API-1
		System.out.println(handle1);
		
		//Open New Tab
		driver.switchTo().newWindow(WindowType.TAB);		//API-2 (New Tab)
		driver.get("https://admin-demo.nopcommerce.com");
		String handle2 = driver.getWindowHandle();		
		System.out.println(handle2);
		
		//Open New Window
		driver.switchTo().newWindow(WindowType.WINDOW);		//API-2 (New Window)
		driver.get("https://www.google.com");
		String handle3 = driver.getWindowHandle();
		System.out.println(handle3);
		
		//Get all handles (1 handle for each tab i.e. 3 handles)
		Set<String> handles = driver.getWindowHandles();	//API-3
		System.out.println("\n All Handles");
		for(String handle : handles) {
			System.out.println(handle);
		}
		
		//How to switch to another tab/window
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(handle1);					//API-4
		System.out.println(driver.getTitle());

		// Additional Scenario-1
		//If the window/Tab is opened by clicking on it, 
		//then handle will not point to this automatically
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		// Observe that it is still pointing to orange hrm home page and not to the new tab.
		System.out.println(driver.getTitle());  
		
		// Additional Scenario-2
		driver.close();
		// The below command would throw an exception because 
		//the active window has already got closed. Switch active window to make it work.
		System.out.println(driver.getTitle());   
	}
}
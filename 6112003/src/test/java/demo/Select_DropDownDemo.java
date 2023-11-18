package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_DropDownDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/DropDown.html");
		
		Select select = new Select(driver.findElement(By.id("cars")));
		
		//1
		System.out.println(select.getFirstSelectedOption().getText());
		
		//2
		List<WebElement> optionElements = select.getOptions();
		List<String> options = new ArrayList<String>();
		
		for(WebElement optionElement : optionElements) {
			options.add(optionElement.getText());
		}
		
		System.out.println(options.toString());
		
		//3
		select.selectByIndex(2);
		
		//4
		select.selectByValue("hyundai");
		
		//5
		select.selectByVisibleText("Mercedes");
		
		
	}
	
}

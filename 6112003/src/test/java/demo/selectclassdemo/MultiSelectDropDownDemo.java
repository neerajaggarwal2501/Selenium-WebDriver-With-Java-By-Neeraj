package demo.selectclassdemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDownDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/NeerajAggarwal/git/SeleniumYT/6112003/src/test/resources/DropDown_MultiSelect.html");
		Select select = new Select(driver.findElement(By.id("cars")));
		//selectByIndex
		select.selectByIndex(0);
		//selectByValue
		select.selectByValue("hyundai");
		//selectByVisibleText
		select.selectByVisibleText("Mercedes");
		//getFirstSelectedOption
		System.out.println(select.getFirstSelectedOption().getText());
		//getAllSelectedOptions
		List<WebElement> optionsElements = select.getAllSelectedOptions();
		List<String> options = new ArrayList<String>();
		for(WebElement optionElement : optionsElements) {
			options.add(optionElement.getText());
		}

		System.out.println(options.toString());
		
		//deselectAll
		
		select.deselectAll();
		
	}

}

package demo.yt;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YT {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get(args[0]);
			String TableElement = "((//div[@id='contents'])[2]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer/div[2]/div[@id='container'])//h3";
			List<WebElement> VideoList = driver.findElements(By.xpath(TableElement));

			int i = 1;
			NumberFormat formatter = new DecimalFormat("00");
			for (WebElement video : VideoList) {
				System.out.println(formatter.format(i++) + (": " + video.getText()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
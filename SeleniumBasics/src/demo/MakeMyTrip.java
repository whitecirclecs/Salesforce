package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakeMyTrip {

	public static void main(String[] args) {
	//	1) Open the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
	//	2) Maximize it
		driver.manage().window().maximize();
		
	//	3) Navigate to MakeMyTrip
		driver.get("https://www.makemytrip.com/");
		
	//	4) Select date as 25th of the next month
		driver.findElement(By.id("hp-widget__depart")).click();
		WebElement comingMonth = driver.findElement(By.xpath("(//div[contains(@class,'last')])[1]"));		
		List<WebElement> calendar = comingMonth.findElements(By.tagName("td"));
		
		for(WebElement t : calendar) {
			if(t.getText().equals("25")) {
				t.click();
				break;
			}
		}
		
	}

}

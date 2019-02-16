package demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowsOnHDFC {
	
	public static void main(String[] args) {
		
			//	1) Open the browser
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			
			//	2) Maixmize it
			driver.manage().window().maximize();
			
			//	3) Navigate to hdfc web app
			driver.get("https://www.hdfcbank.com/");
			
			//	4) Click on Login button
			driver.findElement(By.id("loginsubmit")).click();
								
			//	5) Click on 'Continue to Netbanking' on 2nd window
			ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(1));
			//driver.findElement(By.linkText("CONTINUE TO NETBANKING")).click();
			WebElement netbanking = driver.findElement(By.linkText("CONTINUE TO NETBANKING"));
			Actions action = new Actions(driver);
			action.click(netbanking).perform();
			
			
			//	6) Click on 'Know More' under 'Transfer Money'
			//	7) Click on 'Personal Loan' under 'Apply Now' on 3rd window
			//	8) Enter the phone number in the 4th window
			
	}
	


}

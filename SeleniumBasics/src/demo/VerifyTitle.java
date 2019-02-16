package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {

	public static void main(String[] args) {
		// 1) Open the browser
	//	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// 2) Navigate to the application
		driver.get("https://test.salesforce.com/");
		
		// 3) Take actions on the application
		String expectedTitle = "Login | Salesforce";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Test Case Passed");
		}
		
		else {
			System.out.println("Test Case Failed");
		}
		
		driver.quit();
	}

}

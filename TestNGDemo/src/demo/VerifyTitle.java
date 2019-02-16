package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VerifyTitle {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		// 1) Open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		// 2) Navigate to the application
		driver.get("https://test.salesforce.com/");

	}

	@Test
	public void titleVerification() {
		String expectedTitle = "Login | Salesforce";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

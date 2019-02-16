package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleValidations {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
	}
	
	@Test(priority=0)
	public void verifyTitle() {
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=1,enabled=false)
	public void verifySignInBtnVisibility() {
		boolean signInBtn = driver.findElement(By.id("login-submit")).isDisplayed();
		Assert.assertTrue(signInBtn);
	}
	
	@Test(priority=2)
	public void verifyText() {
		boolean message = driver.getPageSource().contains("Be great at what you do");
		Assert.assertTrue(message);
	}
	
	@Test(priority=3)
	public void verifySearchBtnStatusBeforeText() {
		boolean searchBtn = driver.findElement(By.name("search")).isEnabled();
		Assert.assertFalse(searchBtn);
	}
	
	@Test(priority=4)
	public void verifySearchBtnStatusAfterText() {
		driver.findElement(By.name("first")).sendKeys("Wednesday");
		boolean searchBtn = driver.findElement(By.name("search")).isEnabled();
		Assert.assertTrue(searchBtn);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

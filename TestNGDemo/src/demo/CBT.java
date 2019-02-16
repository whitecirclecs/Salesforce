package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {

	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}

		// In Mac
		else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		}

		// In Win
		else if (browser.equals("Internet Explorer")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
	}

	@Test(priority = 0)
	public void verifyTitle() {
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1)
	public void verifySignInBtnVisibility() {
		boolean signInBtn = driver.findElement(By.id("login-submit")).isDisplayed();
		Assert.assertTrue(signInBtn);
	}

	@Test(priority = 2)
	public void verifyText() {
		boolean message = driver.getPageSource().contains("Be great at what you do");
		Assert.assertTrue(message);
	}

	@Test(priority = 3)
	public void verifySearchBtnStatusBeforeText() {
		boolean searchBtn = driver.findElement(By.name("search")).isEnabled();
		Assert.assertFalse(searchBtn);
	}

	@Test(priority = 4)
	public void verifySearchBtnStatusAfterText() {
		driver.findElement(By.name("first")).sendKeys("Wednesday");
		boolean searchBtn = driver.findElement(By.name("search")).isEnabled();
		Assert.assertTrue(searchBtn);
	}

}

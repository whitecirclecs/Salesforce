package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();

		driver.get("https://test.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("usernam")).sendKeys("abc@gmail.com");

		driver.findElement(By.id("password")).sendKeys("password");

		driver.findElement(By.id("Login")).click();

		String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		String actualErrorMessage = driver.findElement(By.id("error")).getText();

		if (expectedErrorMessage.equals(actualErrorMessage)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}

		driver.quit();

	}

}

package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelDataProvider {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();

		driver.get("https://test.salesforce.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String[][] data = ReadExcel.getData("TestData.xlsx", "Sheet1");
		for(int i=1; i<data.length; i++) {
			
			String username = data[i][1];
			String password = data[i][2];
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
	
			driver.findElement(By.id("password")).sendKeys(password);
	
			driver.findElement(By.id("Login")).click();
	
			String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	
			String actualErrorMessage = driver.findElement(By.id("error")).getText();
	
			if (expectedErrorMessage.equals(actualErrorMessage)) {
				System.out.println("Test Case Passed");
			} else {
				System.out.println("Test Case Failed");
			}
		}

		driver.quit();
	}

}

package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
	//	1) Open the browser
		WebDriver driver = new ChromeDriver();
	
	//	2) Navigate to the application
		driver.get("https://www.flipkart.com/");
		
	//	3) Close the Modal Dialog Box
		driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > button")).click();
		
	//	4) Click on 'Login & Signup'
		driver.findElement(By.linkText("Login & Signup")).click();
		
	//	5) Enter username in the Modal Dialog Box
		driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(1) > input")).sendKeys("abc@gmail.com");
		
		
	}

}

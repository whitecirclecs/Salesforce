package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.cssSelector("body > button")).click();
		
		//Click ok of Alert Box
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}

}

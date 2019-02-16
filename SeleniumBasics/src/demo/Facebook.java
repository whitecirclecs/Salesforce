package demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		driver.findElement(By.linkText("Instagram")).click();
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for(String t : tabs) {
			if(driver.switchTo().window(t).getTitle().equals("Instagram")) {
				driver.switchTo().window(t);
				break;
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.name("emailOrPhone")).sendKeys("Deepinder");
	}

}

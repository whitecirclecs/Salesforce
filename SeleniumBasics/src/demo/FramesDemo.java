package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("DEPRECATED")).click();
		
		//Come out of the frame
		driver.switchTo().defaultContent();
		
		//Go inside second frame
//		driver.switchTo().frame(1);
		//WebElement secondFrame = driver.findElement(By.cssSelector("html > frameset > frameset > frame:nth-child(2)"));
		driver.switchTo().frame(driver.findElement(By.cssSelector("html > frameset > frameset > frame:nth-child(2)")));
		
		driver.findElement(By.linkText("KeyState")).click();
	}

}

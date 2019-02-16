package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://limeandleaf.com/pages/mix-and-match");
		
		//Close Advt
		Thread.sleep(5000);
		
		WebElement pillow = driver.findElement(By.name("Solid Pillow Cover - Fire Coral"));
		WebElement sofa = driver.findElement(By.id("base-room"));
		
		Actions action = new Actions(driver);
//		action.dragAndDrop(pillow, sofa).perform();
		
		Action dragAndDrop = action.dragAndDrop(pillow, sofa).build();
		dragAndDrop.perform();
		
	}

}

package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BarnesAndNoble {
	static WebDriver driver;
	
	public static boolean advtIsPresent() {
		boolean isPresent = true;
		try {
			driver.findElement(By.xpath("//body[contains(@class,'overlay')]")).isDisplayed();
		}
		catch(Exception e) {
			isPresent = false;
		}
		return isPresent;
	}
	
	public static void main(String[] args) throws InterruptedException {
	//	1) Open the browser
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	//	2) Navigate to the application
		driver.get("https://www.barnesandnoble.com/");
		
	//	3) Close advertisement if present
		if(advtIsPresent()) {
			driver.findElement(By.cssSelector("#bx-element-891353-txSrrII > button")).click();
		}
		
	//	4) Hover over ''Hello Sign In'
		WebElement signIn = driver.findElement(By.id("userLinks"));
		Actions action = new Actions(driver);
		action.moveToElement(signIn).perform();		
		
	//	5) Click Sign IN
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		driver.findElement(By.linkText("Sign In")).click();
		
	//	6) Enter username in the modal dialog Box
		WebElement dialogBox = driver.findElement(By.cssSelector("body > div.modal.focus > div > iframe"));
		driver.switchTo().frame(dialogBox);
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	}

}

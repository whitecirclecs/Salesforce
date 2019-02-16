package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSEDemo {
	static WebDriver driver;
	
	public static boolean waitForJStoLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		waitForJStoLoad();
		js.executeScript("document.getElementsByName('userName')[0].value='abc@gmail.com'");
		js.executeScript("document.getElementsByName('password')[0].value='abc@gmail.com'");
		js.executeScript("document.getElementsByName('login')[0].click()");
	}

}

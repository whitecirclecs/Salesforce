package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.geodatasource.com/software/world-major-cities-drop-down-list-source-codes");
		
		//Select Country
		WebElement countries = driver.findElement(By.id("countryCode"));
		Select selectCountry = new Select(countries);
		selectCountry.selectByVisibleText("India");
		
		//Select State
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("regionName")));
		WebElement states = driver.findElement(By.id("regionName"));
		Select selectState = new Select(states);
		selectState.selectByVisibleText(" Gujarat");
		
		//Select City
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cityName")));
		WebElement cities = driver.findElement(By.id("cityName"));
		Select selectCity = new Select(cities);
		//selectCity.selectByVisibleText("Bhuj");
//		selectCity.selectByIndex(4);
		selectCity.selectByValue("Anand");
				
		
		
		
		
	}

}

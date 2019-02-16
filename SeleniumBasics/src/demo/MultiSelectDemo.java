package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelectDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.jqueryfaqs.com/demos/112/");
		
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > button")).click();
		
		//Select Mango
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > ul > li:nth-child(2) > a > label > input[type=\"checkbox\"]")).click();
		
		//select Apple
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > ul > li:nth-child(3) > a > label > input[type=\"checkbox\"]")).click();
				
		//Select Orange
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > ul > li:nth-child(6) > a > label > input[type=\"checkbox\"]")).click();
		
		
	}

}

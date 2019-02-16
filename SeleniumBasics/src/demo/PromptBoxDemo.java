package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptBoxDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://whitecircleschool.com/prompt-box/");
		
		driver.findElement(By.cssSelector("body > div.elementor.elementor-607 > div > div > section.elementor-element.elementor-element-7044e18.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default.elementor-section.elementor-top-section > div > div > div > div > div > div > div > button")).click();
		
		driver.switchTo().alert().sendKeys("Deepinder");
		driver.switchTo().alert().accept();
	}

}

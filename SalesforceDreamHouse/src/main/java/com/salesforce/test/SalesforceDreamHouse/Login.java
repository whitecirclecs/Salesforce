package com.salesforce.test.SalesforceDreamHouse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//private WebElement username = driver.findElement(By.id("username"));
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="Login")
	private WebElement submit;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
	}
	

}

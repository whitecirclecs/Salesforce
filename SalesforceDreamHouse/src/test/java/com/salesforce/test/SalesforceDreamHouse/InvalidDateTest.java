package com.salesforce.test.SalesforceDreamHouse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class InvalidDateTest extends BaseTest{

	@Test
	public void invalidDateTest() {
		login = new Login(driver);
		properties = new PropertiesPage(driver);
		login.applicationLogin("deepinder@acme.com", "Hyderabad1!");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Properties")));
		Utils.waitForJStoLoad(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('slds-context-bar__label-action dndItem')[1].click()");

//		5) Click on 'New' and enter property information
		properties.getNew().click();
		properties.enterInvalidDate("Hyderanad Second Property");

		String expectedErrorMessage = "Invalid data type.";
		String actualErrorMessage = properties.getInvalidDateErrorMessage().getText();

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

}

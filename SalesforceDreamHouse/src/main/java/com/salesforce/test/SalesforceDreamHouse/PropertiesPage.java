package com.salesforce.test.SalesforceDreamHouse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPage {

	@FindBy(linkText = "New")
	private WebElement New;

	@FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
	private WebElement title;

	@FindBy(xpath = "//span[text()='Property Name']/parent::label/following-sibling::input")
	private WebElement propertyName;

	@FindBy(xpath = "//span[text()='Address']/parent::label/following-sibling::input")
	private WebElement address;

	@FindBy(xpath = "//span[text()='City']/parent::label/following-sibling::input")
	private WebElement city;

	@FindBy(xpath = "//span[text()='State']/parent::label/following-sibling::input")
	private WebElement state;

	@FindBy(xpath = "//span[text()='Zip']/parent::label/following-sibling::input")
	private WebElement zip;

	@FindBy(xpath = "//span[text()='Beds']/parent::label/following-sibling::input")
	private WebElement beds;

	@FindBy(xpath = "//span[text()='Baths']/parent::label/following-sibling::input")
	private WebElement baths;

	@FindBy(xpath = "//span[text()='Price']/parent::label/following-sibling::input")
	private WebElement price;

	@FindBy(xpath = "//span[text()='Assessed Value']/parent::label/following-sibling::input")
	private WebElement assessedValue;

	@FindBy(xpath = "//span[text()='Status']/parent::span/following-sibling::div")
	private WebElement status;

	@FindBy(xpath = "//span[text()='Date Listed']/parent::label/following-sibling::div")
	private WebElement dateListed;
	
	@FindBy(xpath="//span[text()='Date Listed']/parent::label/following-sibling::div/input")
	private WebElement date;

	@FindBy(linkText = "Available")
	private WebElement available;

	@FindBy(xpath = "//table[contains(@class,'calGrid')]")
	private WebElement calendar;

	@FindBy(xpath = "//span[text()='Save']/parent::button[@title='Save']")
	private WebElement save;

	@FindBy(xpath = "//span[contains(@class,'toastMessage')]")
	private WebElement successMessage;
	
	@FindBy(xpath="//li[text()='Invalid data type.']")
	private WebElement invalidDateMessage;

	public PropertiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterNewPropertyInformation(String propName) {
		New.click();
		title.sendKeys("Selenium Demo Property");
		propertyName.sendKeys(propName);
		address.sendKeys("48 Brattle St");
		city.sendKeys("Cambridge");
		state.sendKeys("MA");
		zip.sendKeys("02420");
		beds.sendKeys("5");
		baths.sendKeys("2");
		price.sendKeys("250000");
		assessedValue.sendKeys("200000");
		status.click();
		available.click();
		dateListed.click();
		List<WebElement> dates = calendar.findElements(By.tagName("td"));
		for (WebElement t : dates) {
			if (t.getText().equals("7")) {
				t.click();
				break;
			}
		}

		save.click();
	}

	public WebElement getNew() {
		return New;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
	public void enterInvalidDate(String propName) {
		propertyName.sendKeys(propName);
		date.sendKeys("5");
		save.click();
	}
	
	public WebElement getInvalidDateErrorMessage() {
		return invalidDateMessage;
	}

}

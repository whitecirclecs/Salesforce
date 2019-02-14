package com.salesforce.test.SalesforceDreamHouse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Beforeclass");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
}

package com.qa.saucedemo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.HomePage;
import com.qa.saucedemo.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

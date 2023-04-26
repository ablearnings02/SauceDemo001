package com.qa.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.saucelabs.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		System.out.println(actualURL);
		Assert.assertEquals(actualURL, Constants.LOGIN_PAGE_URL);
	}
	
	@Test(priority=3)
	public void loginPageHeaderTest() {
		String actualHeader = loginPage.getPageHeader();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader, Constants.LOGIN_PAGE_HEADER);
		
	}
	
	@Test(priority=4)
	public void doLoginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getfirstItemText(), "Sauce Labs Backpack");
		
	}
	
	
	
	

}

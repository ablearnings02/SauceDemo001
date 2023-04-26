package com.qa.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.saucelabs.utils.Constants;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void getfirstItemTextTest() {
		String actualText = homePage.getfirstItemText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Sauce Labs Backpack");
	}
	
	@Test(priority=2)
	public void getfirstItemPriceTest() {
		String actualPrice = homePage.getfirstItemPrice();
		System.out.println(actualPrice);
		Assert.assertEquals(actualPrice, "$29.99");
	}
	
	@Test(priority=3)
	public void addToCartTest() {
		String removeText = homePage.addToCart();
		System.out.println(removeText);
		Assert.assertEquals(removeText, "Remove");
		
	}
	
	@Test(priority=4)
	public void clickAboutLinkTest() {
		homePage.clickAboutLink();
	}

}

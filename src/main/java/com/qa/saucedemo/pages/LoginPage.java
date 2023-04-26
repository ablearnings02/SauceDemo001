package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucelabs.utils.ElementUtil;

public class LoginPage {
	
//1. Create private WebDriver driver:
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
//2. Create the Page Constructor:
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	

//3. Create private By locators:
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("login-button");
	By loginPageHeader = By.xpath("//div[text()='Swag Labs']");
	
	
	
	
//4. Create Page Actions (Methods):
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public String getLoginPageURL() {
		return driver.getCurrentUrl();	
	}
	
	public String getPageHeader() {
		return driver.findElement(loginPageHeader).getText();
	}
	
	public HomePage doLogin(String uname, String pwd) {
		System.out.println("You are logging with username as: "+ uname + " and password as: " + pwd);
//		driver.findElement(username).sendKeys(uname);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		eleUtil.doSendKeys(username, uname);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new HomePage(driver);
		
	}
	
	
	
	
	

}

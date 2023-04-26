package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucelabs.utils.ElementUtil;

public class HomePage {
	
	//1. Create private WebDriver driver:
	
		private WebDriver driver;
		private ElementUtil eleUtil;
		
		
	//2. Create the Page Constructor:
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
		

	//3. Create private By locators:
		
		By firstItem = By.xpath("//div[text()='Sauce Labs Backpack']");
		By firstItemPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
		By firstItemAddtoCartBtn = By.xpath("(//button[text()='Add to cart'])[1]");
		By firstItemRemoveFromCartBtn = By.xpath("//button[text()='Remove']");
		By openMenu = By.xpath("//button[text()='Open Menu']");
		By aboutPageLink = By.xpath("//a[text()='About']");
		
		
		
		
	//4. Create Page Actions (Methods):
		
		public String getfirstItemText() {
			return driver.findElement(firstItem).getText();
		}
		
		
		public String getfirstItemPrice() {
			return driver.findElement(firstItemPrice).getText();
		}
		
		public String addToCart() {
			driver.findElement(firstItemAddtoCartBtn).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return driver.findElement(firstItemRemoveFromCartBtn).getText();
		}
		
		public void clickAboutLink() {
		
			driver.findElement(openMenu).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			driver.findElement(aboutPageLink).click();
		}

}

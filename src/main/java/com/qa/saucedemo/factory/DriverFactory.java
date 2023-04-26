package com.qa.saucedemo.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	private OptionsManager optionsManager;
	
	/**
	 * This method is used to initialize the WebDriver
	 * @param browserName
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("The browser name is: "+ browserName);
		optionsManager = new OptionsManager(prop);
		
			if(browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(optionsManager.getChromeOptions());
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Please pass the correct browser name !!!");
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.saucedemo.com/");
			
			return driver;
			
			
	}
	
	/**
	 * This method is used to initialize the propertiesand it returns the Properties Object
	 * @return
	 */
	public Properties init_prop() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	

}

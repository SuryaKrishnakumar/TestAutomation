package com.way2Automation.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.way2Automation.helper.TestConstants;

public class TestFixture {
	
	WebDriver chromeDriver;
	
	public TestFixture(){
		System.setProperty(TestConstants.CHROME_DRIVER_PROPERTY, getDriverPath());
		chromeDriver = new ChromeDriver();
	}
	
	public WebDriver getChromeDriver(){
		return chromeDriver;
	}
	
	public void invokeBrowser() {
		try {
			chromeDriver.manage().deleteAllCookies();
//			chromeDriver.manage().window().maximize();
			chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			chromeDriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			chromeDriver.get(TestConstants.DOMAIN);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser(){
		chromeDriver.close();
	}
	
	private String getDriverPath() {
		String basePath = System.getProperty("user.dir");
		String driverPath =  basePath + TestConstants.CHROME_DRIVER_PATH;
		return driverPath;
	}

}

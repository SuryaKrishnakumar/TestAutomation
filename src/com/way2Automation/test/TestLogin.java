package com.way2Automation.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.way2Automation.helper.TestConstants;

public class TestLogin extends AbstractTest{

	WebDriver testDriver;
	
	@BeforeTest
	public void setup(){
		testDriver = getTestFixture().getChromeDriver();
		getTestFixture().invokeBrowser();
	}
	@Parameters({TestConstants.FIELD_EMAIL , TestConstants.FIELD_PASSWORD})
	//@Parameters({"email" , "passwd"})
	@Test	
	public void testLogin(String username, String password) throws InterruptedException{
		// Find signin link button
		By signIn = By.className(TestConstants.FIELD_SIGNIN);
		testDriver.findElement(signIn).click();
		Thread.sleep(2000);
		
		// Find username, password and submit button
		By userElem = By.id(TestConstants.FIELD_EMAIL);
		By passElem = By.id(TestConstants.FIELD_PASSWORD);
		By loginButton= By.id(TestConstants.FIELD_LOGIN);
	
		testDriver.findElement(userElem).sendKeys(username);
		testDriver.findElement(passElem).sendKeys(password);
		Thread.sleep(2000);
		testDriver.findElement(loginButton).click();
		Thread.sleep(2000);

		// Find alert element
		WebElement loggedInUser = testDriver.findElement(
									By.className(TestConstants.FIELD_ACCOUNT));
		Assert.assertEquals(loggedInUser.getText(),TestConstants.FIELD_ACCOUNT);
	}
	
//	@AfterTest
//	public void tearDown(){
//		getTestFixture().closeBrowser();
//	}
}

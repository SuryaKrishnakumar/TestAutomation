package com.way2Automation.test;

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
	
	@Test
	@Parameters({TestConstants.FIELD_EMAIL , TestConstants.FIELD_PASSWORD, TestConstants.FIELD_TESTCASE_ID})
	public void testLogin(String username, String password, String tc_id) throws InterruptedException{
		// Find signin link button
		By signIn = By.className(TestConstants.FIELD_SIGNIN);
		testDriver.findElement(signIn).click();
		
		// Find username, password and submit button
		By userElem = By.id(TestConstants.FIELD_EMAIL);
		By passElem = By.id(TestConstants.FIELD_PASSWORD);
		By loginButton= By.id(TestConstants.FIELD_LOGIN);
	
		testDriver.findElement(userElem).sendKeys(username);
		testDriver.findElement(passElem).sendKeys(password);
		testDriver.findElement(loginButton).click();

		// Find alert element
		//Valid username and password
		if(tc_id == "1"){
			WebElement loggedInUser = testDriver.findElement(By.className(TestConstants.FIELD_ACCOUNT));
			Assert.assertEquals(loggedInUser.getText(),TestConstants.FIELD_USER_NAME);
		}
		//IV U + V P  , IV U+ IV P, IV U + No P
		if(tc_id == "2"){
			testDriver.getPageSource().contains(TestConstants.ALERT_TEXT2);	
		}
		//V U + No P
		if(tc_id == "3"){
			testDriver.getPageSource().contains(TestConstants.ALERT_TEXT1);
		}
		//No U + IV P, No U+ V P
		if(tc_id == "4"){
			testDriver.getPageSource().contains(TestConstants.ALERT_TEXT);		
			}
		// V U + IV P
		if(tc_id == "5"){
			testDriver.getPageSource().contains(TestConstants.ALERT_TEXT3);		
			}
	}
	
	@AfterTest
	public void tearDown(){
		getTestFixture().closeBrowser();
	}
}

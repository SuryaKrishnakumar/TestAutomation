package com.way2Automation.helper;

public interface TestConstants {
	
	public static final String DOMAIN = "http://automationpractice.com/index.php";

	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public static final String CHROME_DRIVER_PATH = "\\assets\\driver\\chrome\\chromedriver.exe";
	
	// fields

	public static final String FIELD_SIGNIN = "login";
	
	public static final String FIELD_EMAIL = "email";
	
	public static final String FIELD_PASSWORD = "passwd";
	
	public static final String FIELD_LOGIN = "SubmitLogin";
	
	public static final String FIELD_ACCOUNT = "account";
	
	public static final String FIELD_USER_NAME = "Test User";
	
	// X-path
	
	public static final String XPATH_SUBMIT = "//*[@type= 'submit']";

	public static final String ALERT_TEXT = "Invalid username password.";
}

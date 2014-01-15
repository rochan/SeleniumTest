package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.LoginPage;

public class TestLoginPage_FireFox_OSX {
	
	private LoginPage page;
	private WebDriver driver;
	private String redirectURL = "http://testhomework.wikia.com/wiki/Test-homework_Wiki";
	private String testUserName = "rochan_test1";
	private String testPassword = "testing";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://testhomework.wikia.com/");
		page = (LoginPage) PageFactory.initElements(driver, LoginPage.class);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	public void testLoginPage() {
		Assert.assertTrue("The browser redirect URL is not equal to " + redirectURL, redirectURL.equals(driver.getCurrentUrl()));
	   	Assert.assertFalse("The browser redirect URL should not equal to 'http://testhomework.wikia.com/'", redirectURL.equals("http://testhomework.wikia.com/"));
	   	page.hoverOverLogin();	
	   	Assert.assertTrue(page.isUserLoginDropDownVisible());
	   	page.loginAs(testUserName, testPassword);
		String displayedName = page.getUserNameLabel();
		Assert.assertFalse("Label is still showing 'Log In' instead of the username.", displayedName.equals("Log in"));
    	Assert.assertTrue("Name being displayed is not the same as the user name. Expecting: " + testUserName + ". Actual: " + displayedName, displayedName.equals(testUserName));
	}
}

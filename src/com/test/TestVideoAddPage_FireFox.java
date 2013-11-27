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

import com.FilePage;
import com.LoginPage;
import com.VideoAddPage;
import com.VideosSortPage;

public class TestVideoAddPage_FireFox {
	private LoginPage page;
	private VideoAddPage videoAddPage;
	private VideosSortPage videosSortPage;
	private FilePage filePage;
	private WebDriver driver;
	private String redirectURL = "http://testhomework.wikia.com/wiki/Test-homework_Wiki";
	private String testUserName = "rochan_test1";
	private String testPassword = "testing";
	private String addVideoRedirectURL = "http://testhomework.wikia.com/wiki/Special:WikiaVideoAdd";
	private String youtubeVideoURL = "http://www.youtube.com/watch?v=h9tRIZyTXTI";
	private String prefix = "Video page File:";
	private String postfix = " was successfully added.";
	private String filePagePrefix = "http://testhomework.wikia.com/wiki/File:"; 
	private String newHeaderPrefix = "File:";
	
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
		page.loginAs(testUserName, testPassword);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	public void testAddVideoPage() {
		//step 1
		driver.get("http://testhomework.wikia.com/");
		Assert.assertTrue("The browser redirect URL is not equal to " + redirectURL, redirectURL.equals(driver.getCurrentUrl()));
	   	Assert.assertFalse("The browser redirect URL should not equal to 'http://testhomework.wikia.com/'", redirectURL.equals("http://testhomework.wikia.com/"));
	   	//step 2
	   	page.hoverOverContribute();
	   	Assert.assertTrue(page.isContributeDropDownVisible());
	   	//step 3
	   	videoAddPage = page.clickAddVideoButton();
	   	Assert.assertTrue("The browser redirect URL is not equal to " + addVideoRedirectURL, addVideoRedirectURL.equals(driver.getCurrentUrl()));
	   	//step 4
	   	videoAddPage.typeVideoURL(youtubeVideoURL);
	   	videosSortPage = videoAddPage.addVideo();
	   	String topMsg = videosSortPage.getFlashMsg();
	   	String videoTitle = videosSortPage.getFirstVideoTitle();
	   	String flashFileName = topMsg.substring(topMsg.indexOf("File"), topMsg.indexOf("was")-1);
	   	
	   	Assert.assertTrue(topMsg.equals(prefix+videoTitle+postfix));
	   	//step 5
	   	filePage = videosSortPage.clickFileLink();	
    	String newHeaderText = filePage.getFormattedHeaderTest();
    	String urlText = driver.getCurrentUrl();
    	Assert.assertTrue("The browser redirect URL is not equal to " + filePagePrefix+newHeaderText, urlText.equals(filePagePrefix+newHeaderText));
	   	//step 6
    	Assert.assertTrue("Filename is not the same as on the flash message", flashFileName.replace(' ', '_').equals(newHeaderPrefix+newHeaderText));
	}
}

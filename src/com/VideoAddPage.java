package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class VideoAddPage {
	
	private final WebDriver driver;
	
	@FindBy(className = "submits")
	private WebElement addButton;
	@FindBy(id = "wpWikiaVideoAddUrl")
	private WebElement videoAddURLEdit;

    public VideoAddPage(WebDriver driver) {
        this.driver = driver;     
    }
    
    public VideoAddPage typeVideoURL(String videoURL) {
    	videoAddURLEdit.sendKeys(videoURL);
    	return this;
    }
    
    public VideosSortPage addVideo() {
    	addButton.submit();
    	return PageFactory.initElements(driver, VideosSortPage.class);
    }
    
}

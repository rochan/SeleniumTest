package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideosSortPage {
	
	private final WebDriver driver;

	@FindBy(className = "msg")
    private WebElement topMsg;
    @FindBy(xpath = "//*[@id='mw-content-text']/div[2]/div[1]/a/span/span[1]")
    private WebElement firstVideoSlot;
    @FindBy(xpath = "/html/body/div[4]/div/a")
    private WebElement fileLink;

    public VideosSortPage(WebDriver driver) {
        this.driver = driver;     
    }
    
    public String getFlashMsg() {
    	return topMsg.getText();
    }
    
    public String getFirstVideoTitle() {
    	return firstVideoSlot.getText();
    }
    
    public FilePage clickFileLink() {
    	fileLink.click();
    	return PageFactory.initElements(driver, FilePage.class);
    }
}

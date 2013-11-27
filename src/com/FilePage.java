package com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilePage {
	
	private final WebDriver driver;
	
    @FindBy(xpath = "/html/body/section/div[2]/article/div/header/h1")
    private WebElement headerH1;


    public FilePage(WebDriver driver) {
        this.driver = driver;     
    }
    
    public String getHeaderText() {
    	return headerH1.getText();
    }
    
    public String getFormattedHeaderTest(){
    	return getHeaderText().replace(' ', '_');
    }

}

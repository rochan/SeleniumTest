package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;     
    }

    @FindBy(className = "ajaxLogin")
    private WebElement loginLabel;
    @FindBy(id = "UserLoginDropdown")
    private WebElement userLoginDropDown;
    @FindBy(name = "username")
    private WebElement usernameEdit;
    @FindBy(name = "password")
    private WebElement passwordEdit;
    @FindBy(className = "login-button")
    private WebElement loginButton;
    @FindBy(id = "AccountNavigation")
    private WebElement usernameLabel;
    @FindBy(className = "wikia-menu-button")
    private WebElement contributeButton;
    @FindBy(className = "chevron")
    private WebElement contributeMenu;
    @FindBy(xpath = "/html/body/section/div[2]/header/div/nav/ul/li[2]/a[@data-id='wikiavideoadd']")
    private WebElement addVideoButton;
        
    public LoginPage typeUsername(String username) {
    	usernameEdit.sendKeys(username);
    	return this;
    }
    
    public LoginPage typePassword(String password) {
    	passwordEdit.sendKeys(password);
    	return this;
    }
    
    public LoginPage loginAs(String username, String password) {
    	hoverOverLogin();
    	typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
    
    public boolean isUserLoginDropDownVisible() {
    	return userLoginDropDown.isDisplayed();
    }
    
    public boolean isContributeDropDownVisible() {
    	return contributeMenu.isDisplayed();
    }
    
    public String getUserNameLabel() {
    	return usernameLabel.getText();
    }
       
    public void hoverOverLogin() {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(loginLabel);
    	actions.perform();
    	loginLabel.click();
    }
    
    public void hoverOverContribute() {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(contributeButton);
    	actions.perform();
    	contributeButton.click();
    }
    
    public VideoAddPage clickAddVideoButton() {
    	addVideoButton.click();  	
    	return PageFactory.initElements(driver, VideoAddPage.class);
    }
    
    public LoginPage submitLogin() {
    	loginButton.submit();
    	return new LoginPage(driver);	
    }
}

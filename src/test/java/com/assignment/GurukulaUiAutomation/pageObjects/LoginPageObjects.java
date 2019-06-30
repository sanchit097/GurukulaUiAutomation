package com.assignment.GurukulaUiAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.assignment.GurukulaUiAutomation.utilities.SeleniumBase;

public class LoginPageObjects {

    WebDriver driver;
    SeleniumBase seleniumBase;

    public LoginPageObjects(WebDriver webDriver) {
	PageFactory.initElements(webDriver, this);
	this.driver = webDriver;
	seleniumBase = new SeleniumBase(driver);
    }

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameTxtBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordTxtBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div/form/button")
    private WebElement authenticateBtn;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div[2]/h1")
    public WebElement welcomeTitle;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div[2]/div/div[1]/a")
    private WebElement loginBtn;

    public void clickLogin() {
	loginBtn.click();
    }

    public void enterCredentials(String username, String password) {
	usernameTxtBox.sendKeys(username);
	passwordTxtBox.sendKeys(password);

    }

    public void clickAuthenticate() {
	authenticateBtn.click();
	seleniumBase.waitForElement(welcomeTitle, 3);
    }
}

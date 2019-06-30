package com.assignment.GurukulaUiAutomation.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.assignment.GurukulaUiAutomation.utilities.SeleniumBase;

public class RegistrationPageObjects {
    WebDriver driver;
    SeleniumBase seleniumBase;

    public RegistrationPageObjects(WebDriver webDriver) {
	PageFactory.initElements(webDriver, this);
	this.driver = webDriver;
	seleniumBase = new SeleniumBase(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div[2]/div/div[2]/a")
    private WebElement registerLink;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div/h1")
    private WebElement registerTitle;

    @FindBy(how = How.NAME, using = "login")
    private WebElement usernameTxtBox;

    @FindBy(how = How.NAME, using = "email")
    private WebElement emailTxtBox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.NAME, using = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div/form/button")
    private WebElement registerBtn;
    
    @FindBy(how = How.CLASS_NAME, using ="alert-success")
    private WebElement registerSucess;

    public void clickRegisterLink() {
	SeleniumBase.sleep(2);
	
	registerLink.click();
	SeleniumBase.sleep(2);
	assertTrue(SeleniumBase.isElementVisible(registerTitle));
    }

    public void enterLogin(String loginName) {
	usernameTxtBox.sendKeys(loginName);
    }

    public void enterEmail(String email) {
	emailTxtBox.sendKeys(email);
    }

    public void enterPassword(String pass) {
	password.sendKeys(pass);
	
    }
    
    public void enterConfirmPassword(String password) {
	confirmPassword.sendKeys(password);
    }
    public void clickRegister() {
	SeleniumBase.sleep(2000);
	registerBtn.click();
    }
    
    public void verfiyRegistration() {
	SeleniumBase.sleep(2000);
	assertTrue("Registration unSuccessful",registerSucess.isDisplayed());
    }
    
}
package com.assignment.GurukulaUiAutomation.utilities;

import org.openqa.selenium.WebDriver;

import com.assignment.GurukulaUiAutomation.pageObjects.BranchPageObjects;
import com.assignment.GurukulaUiAutomation.pageObjects.HomePageObjects;
import com.assignment.GurukulaUiAutomation.pageObjects.LoginPageObjects;
import com.assignment.GurukulaUiAutomation.pageObjects.RegistrationPageObjects;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPageObjects loginPageObj;
    private RegistrationPageObjects registerPageObj;
    private HomePageObjects homePageObj;
    private BranchPageObjects branchPageObj;

    public PageObjectManager(WebDriver webDriver) {
	this.driver = webDriver;
    }

    public LoginPageObjects getLoginPageObj() {
	return (loginPageObj == null) ? loginPageObj = new LoginPageObjects(driver) : loginPageObj;
    }

    public RegistrationPageObjects getRegisterPageObj() {
	return (registerPageObj == null) ? registerPageObj = new RegistrationPageObjects(driver) : registerPageObj;
    }

    public HomePageObjects getHomePageObj() {
	return (homePageObj == null) ? homePageObj = new HomePageObjects(driver) : homePageObj;
    }

    public BranchPageObjects getBranchPageObj() {
	return (branchPageObj == null) ? branchPageObj = new BranchPageObjects(driver) : branchPageObj;
    }

}

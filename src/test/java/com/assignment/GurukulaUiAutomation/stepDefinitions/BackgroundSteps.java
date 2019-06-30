package com.assignment.GurukulaUiAutomation.stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.assignment.GurukulaUiAutomation.pageObjects.LoginPageObjects;
import com.assignment.GurukulaUiAutomation.utilities.Log;
import com.assignment.GurukulaUiAutomation.utilities.PageObjectManager;
import com.assignment.GurukulaUiAutomation.utilities.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BackgroundSteps {

    WebDriver driver;
    LoginPageObjects loginpageObj;
    PageObjectManager pageObjectManager;
    TestContext context;

    public static Logger logger;

    public BackgroundSteps(TestContext context) {
	this.context = context;
	driver = context.getWebDriverManager().getDriver();
	pageObjectManager = context.getPageObjectManager();
	loginpageObj = pageObjectManager.getLoginPageObj();
	Log.loadlog4j("resources/configuration/log4j.xml");
	logger = Log.getLog(BackgroundSteps.class.getName());
    }

    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() throws Exception {
	logger.info(".................Web driver is loaded.................");
	driver.get(context.getURl());
	loginpageObj.clickLogin();
    }

    @When("^I enter following for login$")
    public void i_enter_following_for_login(Map<String, String> credential) throws Exception {
	loginpageObj.enterCredentials(credential.get("username"), credential.get("password"));
    }

    @Then("^I should be navigated to homepage$")
    public void i_should_be_navigated_to_homepage() throws Exception {
	loginpageObj.clickAuthenticate();
	assertTrue("user not logged in", loginpageObj.welcomeTitle.isDisplayed());

    }

}

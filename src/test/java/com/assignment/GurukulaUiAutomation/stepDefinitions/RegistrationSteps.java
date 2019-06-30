package com.assignment.GurukulaUiAutomation.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.assignment.GurukulaUiAutomation.pageObjects.RegistrationPageObjects;
import com.assignment.GurukulaUiAutomation.utilities.Log;
import com.assignment.GurukulaUiAutomation.utilities.PageObjectManager;
import com.assignment.GurukulaUiAutomation.utilities.TestContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {

    WebDriver driver;
    RegistrationPageObjects registerPageObj;
    PageObjectManager pageObjectManager;
    TestContext context;
    public static Logger logger;

    public RegistrationSteps(TestContext context) {
	this.context = context;
	driver = context.getWebDriverManager().getDriver();
	pageObjectManager = context.getPageObjectManager();
	registerPageObj = pageObjectManager.getRegisterPageObj();
	Log.loadlog4j("resources/configuration/log4j.xml");
	logger = Log.getLog(BackgroundSteps.class.getName());
    }

    @Given("^I am at registration page$")
    public void i_am_at_registration_page() throws Throwable {
	driver.get(context.getURl());
        registerPageObj.clickRegisterLink();
    }

    @When("^I enter valid login as (.+)$")
    public void i_enter_valid_login_as(String login) throws Throwable {
   registerPageObj.enterLogin(login);
    }

    @Then("^i should be successfully logged in$")
    public void i_should_be_successfully_logged_in() throws Throwable {
        registerPageObj.verfiyRegistration();
    }

    @And("^enter email as (.+)$")
    public void enter_email_as(String email) throws Throwable {
        registerPageObj.enterEmail(email);
    }

    @And("^enter password as (.+)$")
    public void enter_password_as(String password) throws Throwable {
        registerPageObj.enterPassword(password);
    }

    @And("^enter confirm password as (.+)$")
    public void enter_confirm_password_as(String confirmpassword) throws Throwable {
        registerPageObj.enterConfirmPassword(confirmpassword);
    }

    @And("^click on register button$")
    public void click_on_register_button() throws Throwable {
        registerPageObj.clickRegister();
    }
}

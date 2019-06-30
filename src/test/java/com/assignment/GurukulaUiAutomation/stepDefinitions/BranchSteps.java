package com.assignment.GurukulaUiAutomation.stepDefinitions;

import org.apache.log4j.Logger;

import com.assignment.GurukulaUiAutomation.pageObjects.BranchPageObjects;
import com.assignment.GurukulaUiAutomation.pageObjects.HomePageObjects;
import com.assignment.GurukulaUiAutomation.utilities.Log;
import com.assignment.GurukulaUiAutomation.utilities.PageObjectManager;
import com.assignment.GurukulaUiAutomation.utilities.TestContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BranchSteps {

    HomePageObjects homePageObj;
    PageObjectManager pageObjectManager;
    TestContext context;
    BranchPageObjects branchPageObj;
    public static Logger logger;

    public BranchSteps(TestContext context) {
	this.context = context;
	pageObjectManager = context.getPageObjectManager();
	homePageObj = pageObjectManager.getHomePageObj();
	branchPageObj= pageObjectManager.getBranchPageObj();
	Log.loadlog4j("resources/configuration/log4j.xml");
	logger = Log.getLog(BackgroundSteps.class.getName());
    }

    @Given("^I am at branch creation page$")
    public void i_am_at_branch_creation_page() throws Throwable {
        homePageObj.selectBranch();
        
    }

    @When("^i click on create new branch button$")
    public void i_click_on_create_new_branch_button() throws Throwable {
	branchPageObj.clickCreateBranch();
    }

    @When("^i click on edit branch button of code (.+)$")
    public void i_click_on_edit_branch_button(String code) throws Throwable {
	branchPageObj.clickEditBranch(code);
    }

    @When("^i click on delete button of (.+)$")
    public void i_click_on_delete_button_of(String branchCode) throws Throwable {
        branchPageObj.clickDeleteBranch(branchCode);
    }

    @And("^i confirms deletion$")
    public void i_click_on_delete_button_of_confirm_page() throws Throwable {
        branchPageObj.DeleteBranch();
    }
    
    @Then("^new branch should be created with Code (.+)$")
    public void new_branch_should_be_created_with_code(String branchcode) throws Throwable {
        branchPageObj.verifyBranchCreation(branchcode);
    }

    @Then("^branch should be edited with code (.+)$")
    public void branch_should_be_edited_with_code(String branchcode) throws Throwable {
	branchPageObj.verifyBranchCreation(branchcode);
    }
    
    @Then("^(.+) branch should be deleted$")
    public void branch_should_be_deleted(String code) throws Throwable {
        branchPageObj.verfiyDeleteBranch(code);
    }

    @And("^enter branch (.+) and (.+)$")
    public void enter_branch_and(String branchname, String branchcode) throws Throwable {
        branchPageObj.enterName(branchname);
        branchPageObj.enterCode(branchcode);
    }

    @And("^press save branch button$")
    public void press_save_branch_button() throws Throwable {
        branchPageObj.clickSave();
    }

}

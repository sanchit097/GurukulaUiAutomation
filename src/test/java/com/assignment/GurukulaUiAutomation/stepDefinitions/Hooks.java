package com.assignment.GurukulaUiAutomation.stepDefinitions;


import com.assignment.GurukulaUiAutomation.utilities.TestContext;

import cucumber.api.java.After;

public class Hooks {

    TestContext testContext;
    
    public Hooks(TestContext context) {
	testContext = context;
    }
    
    @After
    public void closeDriver() throws Exception {
	testContext.getWebDriverManager().closeDriver();
    }
}

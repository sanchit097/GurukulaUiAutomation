package com.assignment.GurukulaUiAutomation.utilities;

public class TestContext {

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() {
	webDriverManager = new WebDriverManager();
	pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
	return webDriverManager;

    }

    public PageObjectManager getPageObjectManager() {
	return pageObjectManager;

    }
    
    public String getURl() {
	return webDriverManager.getConfigReader().getUrl();
    }
}

package com.assignment.GurukulaUiAutomation.pageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.assignment.GurukulaUiAutomation.utilities.SeleniumBase;

public class BranchPageObjects {

    WebDriver driver;
    SeleniumBase seleniumBase;
    private String branchId = "";

    public BranchPageObjects(WebDriver webDriver) {
	this.driver = webDriver;
	seleniumBase = new SeleniumBase(driver);
    }

    public void clickCreateBranch() {

	SeleniumBase.sleep(2);
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button")).click();
	SeleniumBase.waitForElementIsVisible(By.id("myBranchLabel"));
	assertTrue(driver.findElement(By.id("myBranchLabel")).isDisplayed());
    }

    public void enterName(String name) {

	WebElement nameTxtbox = driver.findElement(By.name("name"));
	nameTxtbox.clear();
	SeleniumBase.sleep(1000);
	nameTxtbox.sendKeys(name);
    }

    public void enterCode(String code) {
	WebElement codeTxtBox = driver.findElement(By.name("code"));
	codeTxtBox.clear();
	SeleniumBase.sleep(1000);
	codeTxtBox.sendKeys(code);
    }

    public void clickSave() {
	SeleniumBase.sleep(2);
	WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"saveBranchModal\"]/div/div/form/div[3]/button[2]"));
	seleniumBase.waitForElementClickable(saveBtn, 2);
	saveBtn.click();
    }

    public void verifyBranchCreation(String code) {
	SeleniumBase.sleep(5000);
	List<WebElement> branchResult = driver.findElement(By.className("table-striped"))
		.findElements(By.tagName("td"));
	boolean result = false;
	for (WebElement branch : branchResult) {
	    SeleniumBase.sleep(1000);
	    if (branch.getText().equalsIgnoreCase(code)) {
		result = true;
		break;
	    }
	}
	assertTrue("Branch not created", result);
    }

    public void clickEditBranch(String code) {
	List<WebElement> branchRow = driver.findElement(By.className("table-striped")).findElements(By.tagName("tr"));
	BranchLoop: for (WebElement row : branchRow) {
	    List<WebElement> branchColoumn = row.findElements(By.tagName("td"));
	    for (WebElement col : branchColoumn) {
		if (col.getText().equalsIgnoreCase(code)) {
		    row.findElement(By.className("btn-primary")).click();
		    break BranchLoop;
		}
	    }
	}
    }

    public void clickDeleteBranch(String code) {
	List<WebElement> branchRow = driver.findElement(By.className("table-striped")).findElements(By.tagName("tr"));
	BranchLoop: for (WebElement row : branchRow) {
	    List<WebElement> branchColoumn = row.findElements(By.tagName("td"));
	    for (WebElement col : branchColoumn) {
		if (col.getText().equalsIgnoreCase(code)) {
		    branchId = row.findElements(By.tagName("a")).get(0).getText();
		    row.findElement(By.className("btn-danger")).click();
		    break BranchLoop;
		}
	    }
	}
	SeleniumBase.sleep(2);
	// assertTrue(driver.findElement(By.id("deleteBranchConfirmation")).isDisplayed());
    }

    public void DeleteBranch() {
	driver.findElement(By.name("deleteForm")).findElement(By.className("btn-danger")).click();
    }

    public void verfiyDeleteBranch(String code) {
	List<WebElement> branchResult = driver.findElement(By.className("table-striped"))
		.findElements(By.tagName("td"));
	for (WebElement branch : branchResult) {
	    assertFalse("Branch is not deleted", branch.getText().equalsIgnoreCase(branchId));
	}
    }
}

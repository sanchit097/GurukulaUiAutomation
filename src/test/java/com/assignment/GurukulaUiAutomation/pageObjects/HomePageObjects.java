package com.assignment.GurukulaUiAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assignment.GurukulaUiAutomation.utilities.SeleniumBase;


public class HomePageObjects {

    WebDriver driver;
    SeleniumBase seleniumBase;

    public HomePageObjects(WebDriver webDriver) {

	this.driver = webDriver;
	seleniumBase = new SeleniumBase(driver);
    }
    
    public void selectBranch() {
  	SeleniumBase.sleep(1000);
  	WebElement entitiesDrpDwn= driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a"));
  	entitiesDrpDwn.click();
  	SeleniumBase.sleep(2000);
  	SeleniumBase.waitForElementIsVisible(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[1]/a"));
  	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[1]/a")).click();
      }
   
}

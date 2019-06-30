package com.assignment.GurukulaUiAutomation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "resources/features" }, glue = "com.assignment.GurukulaUiAutomation.stepDefinitions", tags = {
	"@assignment" }, plugin = { "pretty", "html:target/cucumber" }, monochrome = true)
public class TestRunner {


}

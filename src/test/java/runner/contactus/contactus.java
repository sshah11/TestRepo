package runner.contactus;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/contactus/contactus.feature" }, glue = {
		"classpath:stepdefinition.contactus",
		"classpath:helper.pageobjectmodel" }, plugin = {"html:target/cucumber-html-report"})

public class contactus extends AbstractTestNGCucumberTests  {
	
}

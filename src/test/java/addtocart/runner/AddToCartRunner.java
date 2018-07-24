package addtocart.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/addtocart/addtocart.feature" }, glue = {
		"classpath:stepdefinition.addtocart",
		"classpath:helper.pageobjectmodel" }, plugin = {"html:target/cucumber-html-report"})

public class AddToCartRunner extends AbstractTestNGCucumberTests  {
	
}

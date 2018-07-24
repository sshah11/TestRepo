package runner.productfilter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/verifyproductpagefilter/productpagefilter.feature" }, glue = {
		"classpath:stepdefinition.productfilter",
		"classpath:helper.pageobjectmodel" }, plugin = {"html:target/cucumber-html-report"})

public class productfilter extends AbstractTestNGCucumberTests  {
	
}

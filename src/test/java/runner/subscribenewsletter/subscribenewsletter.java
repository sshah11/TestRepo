package runner.subscribenewsletter;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "classpath:featurefile/newsletter/SubsNewsLetter.feature" }, glue = {
		"classpath:stepdefinition.subscribenewsletter",
		"classpath:helper" }, plugin = {"html:target/cucumber-html-report"})
public class subscribenewsletter  extends AbstractTestNGCucumberTests {
	
}

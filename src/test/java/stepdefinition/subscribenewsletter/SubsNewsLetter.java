package stepdefinition.subscribenewsletter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.pageobjectmodel.NewsLetterSubs;
import helper.testbase.TestBase;
import stepdefinition.addtocart.AddToCart;



public class SubsNewsLetter {
	
	NewsLetterSubs newslettersubs;
    TestBase testbase;
    
	@Given("^User is on application$")
	public void user_is_on_application() throws Throwable {
		AddToCart AddToCart = new AddToCart();
		AddToCart.navigate_to_application();
	}

	@When("^User provides email in Newsletter\\.$")
	public void user_provides_email_in_Newsletter() throws Throwable {
		newslettersubs = new NewsLetterSubs(TestBase.driver);
		newslettersubs.EnterEmailId();
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		newslettersubs.ClickSubmit();
	}

	@Then("^Message should be displayed  Newsletter : You have successfully subscribed to this newsletter\\.$")
	public void message_should_be_displayed_Newsletter_You_have_successfully_subscribed_to_this_newsletter() throws Throwable {
		newslettersubs.VerifySubscribtion();
	}
}
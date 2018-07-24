package stepdefinition.contactus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.pageobjectmodel.ContactUs;
import helper.testbase.TestBase;
import stepdefinition.addtocart.AddToCart;

public class ContactUsFrom {
    
	
	ContactUs contactus;
	@Given("^User in on Application$")
	public void user_in_on_Application() throws Throwable {
		AddToCart AddToCart = new AddToCart();
		AddToCart.navigate_to_application();
	  
	}

	@When("^User clicked on ContactUs Icon$")
	public void user_clicked_on_ContactUs_Icon() throws Throwable {
		contactus = new ContactUs(TestBase.driver);
		contactus.ClickContactUs();
				
	}

	@When("^Selects the subject Heading as \"([^\"]*)\"$")
	public void selects_the_subject_Heading_as(String arg1) throws Throwable {
	     contactus.UserSelectsSubjectHeading(arg1);
	}

	@When("^user click on the send button$")
	public void user_click_on_the_send_button() throws Throwable {
		contactus.ClickOnSent();
	}

	@Then("^An error message should be displayed as \"([^\"]*)\"$")
	public void an_error_message_should_be_displayed_as(String arg1) throws Throwable {
		contactus.VerifyAlertMsgDisplayed();
	}
}

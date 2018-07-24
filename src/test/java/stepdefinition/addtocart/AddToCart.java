package stepdefinition.addtocart;


import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.pageobjectmodel.HomePage;
import helper.testbase.TestBase;

public class AddToCart {
	 
	
	 HomePage homepage;
	 
	
	 
	@Given("^navigate to application$")
	public void navigate_to_application() throws Throwable {
	    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
	    TestBase.driver = new ChromeDriver();
		TestBase.driver.get("http://automationpractice.com/index.php");
		System.out.println("Navigated to homepage");
	 }

	@When("^user click on add to cart$")
	public void user_click_on_add_to_cart() throws Throwable {
		homepage = new HomePage(TestBase.driver);
		homepage.ClickAddToCart();  
		System.out.println("Succesfully clicked");
	 }

	@When("^user should be able to click on proceed to checkout$")
    public void user_should_be_able_to_click_on_proceed_to_checkout() throws Throwable {
		homepage.CheckOutToProceed();
      
	}

	@When("^enter the email address as \"([^\"]*)\"$")
	public void enter_the_email_address_as(String arg1) throws Throwable { 
		homepage.EnterEmailId(arg1);
	}

	@When("^enter password as \"([^\"]*)\"$")
	public void enter_password_as(String arg1) throws Throwable {
		homepage.EnterPassword(arg1);
	}

	@When("^Login is successful$")
	public void login_is_successful() throws Throwable {
		homepage.VerifySuccesfullLogin();
	}

    
	@When("^user should click the terms of service button and click on checkout$")
	public void user_should_click_the_terms_of_service_button_and_click_on_checkout() throws Throwable {
		homepage.AcceptTermsAndConditions();
		System.out.println("Conditions clicked");
		
  }

	@When("^user should click on pay by check option$")
	public void user_should_click_on_pay_by_check_option() throws Throwable {
		homepage.PaymentOption();
	    
	}

	@Then("^user should be able to see confirm my order box$")
	public void user_should_be_able_to_see_confirm_my_order_box() throws Throwable {
		homepage.OrderPlacement();
	   
	}
}




package stepdefinition.productfilter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.pageobjectmodel.ProductFilterPage;
import helper.testbase.TestBase;
import stepdefinition.addtocart.AddToCart;

public class ProductFilter {
	
	ProductFilterPage productfilterpage;
	TestBase testbase;
	
	
	@Given("^User is on Application homepage$")
	public void user_is_on_Application_homepage() throws Throwable {
		AddToCart AddToCart = new AddToCart();
		AddToCart.navigate_to_application();
	  
	}

	@When("^User click on homepage search button and supplies \"([^\"]*)\"$")
	public void user_click_on_homepage_search_button_and_supplies(String arg1) throws Throwable {
		productfilterpage = new ProductFilterPage(TestBase.driver);
		productfilterpage.EnterTextInSearchBox(arg1);
	}

	@When("^Clicks on the search box$")
	public void clicks_on_the_search_box() throws Throwable {
		productfilterpage.ClickSubmit();
	}

	@Then("^Search results page should be displaying products$")
	public void search_results_page_should_be_displaying_products() throws Throwable {
		productfilterpage.SearchPageIsDisplayed();
	}

	@When("^User clicks on the User by and selects \"([^\"]*)\"$")
	public void user_clicks_on_the_User_by_and_selects(String arg1) throws Throwable {
		productfilterpage.SelectSortingOrder(arg1);
	}

	@Then("^Products should be displayed in Ascending order of price$")
	public void products_should_be_displayed_in_Ascending_order_of_price() throws Throwable {
		productfilterpage.VerifySorttiingOrder();
	}
}

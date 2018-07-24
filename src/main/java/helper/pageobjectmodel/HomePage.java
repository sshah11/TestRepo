package helper.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.testbase.TestBase;
import helper.wait.HelperWait;

public class HomePage {
	
	WebDriver driver;
	
	HelperWait helperwait = new HelperWait();
	TestBase testbase;
	public String BeforeShippingCheckOutText = "Choose a shipping option for this address: My address";
	public String PaymentPageConfirmationText = "Please choose your payment method";
	String OrderConfirmationText ="Your order on My Store is complete.";
	
	@FindBy(xpath="//*[@class='tab-content']/ul[1]/li[1]/div/div[2]/div[2]/a[1]/span")
	WebElement AddToCart;
   
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement  SmallWindowCheckOut;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/a/span")
	WebElement SummaryCheckOut;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span")
	WebElement SubmitButton;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/button/span")
	WebElement AddressCheckOut;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/button/span")
	WebElement ShippingTextElement;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/button/span")
	WebElement ShippingCheckOut;
	
	@FindBy(xpath="//*[@class='checkbox']/div/span/input")
	WebElement RadioCheckBox;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement BeforePaymentTextElement;
	
	@FindBy(xpath="//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
	WebElement PayByCheck;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement OrderConfirmTextElement;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']/button/span")
	WebElement OrderConfirmation;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helperwait.waitForElement(driver, AddToCart, 60);
	}
	
	
   public void ClickAddToCart() {
	try {
		   if (AddToCart.isDisplayed()) {
			   AddToCart.click();
			   System.out.println("click on the AddToCart Button on Homepage");
			}
	}
	   			catch(Exception e ){
	   				System.out.print(e);
	   			}
   	}
  
    public void CheckOutToProceed() {
    	try {
    		helperwait.waitForElement(driver,30,SmallWindowCheckOut);
    	if(SmallWindowCheckOut.isDisplayed())
    		SmallWindowCheckOut.click();
    		SummaryCheckOut.click();
    		}
    		catch(Exception e) {
    			System.out.print(e);
    		}
    }
   
  
    public void EnterEmailId(String Emailid) {
    	
    	EmailId.sendKeys(Emailid);
    	
    }
    
    public void EnterPassword(String Pwd) {
    	Password.sendKeys(Pwd);
    	SubmitButton.click();
    }
   
    public void VerifySuccesfullLogin() {
    
    	try {
    		if (AddressCheckOut.isDisplayed()) {
    		AddressCheckOut.click();
    		}
    	}
    	catch(Exception e) {
    		System.out.print(e);
    	}
    }
    
    public void AcceptTermsAndConditions() {
    	testbase = new TestBase();
    	testbase.VerifyTextDisplayed(ShippingTextElement, BeforeShippingCheckOutText);
    	RadioCheckBox.click();
    	ShippingCheckOut.click();
    	System.out.println("Click on terms and conditions");
     }
    
    public void PaymentOption() {
    	testbase.VerifyTextDisplayed(BeforePaymentTextElement, PaymentPageConfirmationText);
    	PayByCheck.click();
    	
    	
    }
    public void OrderPlacement() {
    	testbase.VerifyTextDisplayed(OrderConfirmTextElement, OrderConfirmationText);
    	OrderConfirmation.click();
    	
    }
    
   
}

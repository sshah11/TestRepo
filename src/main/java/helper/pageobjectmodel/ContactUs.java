package helper.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.testbase.TestBase;
import helper.wait.HelperWait;
import junit.framework.Assert;


public class ContactUs {
	
	HelperWait helperwait = new HelperWait();
    WebDriver driver;
	String ContactFromHeaderText = "Customer service - Contact us";
	TestBase testbase;
	String ActualErrorMessage = "Invalid email address.";
	
	@FindBy(xpath="//header[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement ContactUsButton;
	
	@FindBy(xpath="//header[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement ContactFormPageHeaderTextElement;
	
	@FindBy(xpath="//select[@id='id_contact']")
	WebElement SubjectHeadingSelect;
	
	@FindBy(xpath="//div[@class='submit']/button/span")
	WebElement SentButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger']/ol/li")
	WebElement AlertElement;
	
	public ContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helperwait.waitForElement(driver, ContactUsButton, 60);
	}
	
	public void ClickContactUs() {
		ContactUsButton.click();
		testbase= new TestBase();
		testbase.VerifyTextDisplayed(ContactFormPageHeaderTextElement, ContactFromHeaderText);     
	}
	
	public void UserSelectsSubjectHeading(String Value) {
		Select select = new Select(SubjectHeadingSelect);
		select.selectByVisibleText(Value);
		
	}
	
	public void ClickOnSent() {
		SentButton.click();
	}
	
	@SuppressWarnings("deprecation")
	public void VerifyAlertMsgDisplayed() {
		String ExpectedErrorMsg = AlertElement.getText();
	   Assert.assertEquals(ExpectedErrorMsg, ActualErrorMessage);
	}
	
}

package helper.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.wait.HelperWait;

public class NewsLetterSubs {
   
    HelperWait helperwait = new HelperWait();
    WebDriver driver;
    
    String NewsLetterConfirMsg = "You have successfully subscribed to this newsletter.";
    
	@FindBy(xpath="//div[@id='newsletter_block_left']/div/form/div/input")
	WebElement EmailID;
	
	@FindBy(xpath="//div[@id='newsletter_block_left']/div/form/div/button")
	WebElement SubmitButton;
	
	
	public NewsLetterSubs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helperwait.waitForElement(driver, EmailID, 60);
	}
	
	
	public void EnterEmailId() {
		int Midpart = (int)(Math.random()*Integer.MAX_VALUE);
		String Username = "User" + Midpart + "@gmail.com";
		EmailID.sendKeys(Username);
	}
	
	public void ClickSubmit() {
		SubmitButton.click();
	
	}
	public void VerifySubscribtion() {
		String ActualSubsText = EmailID.getAttribute("value");
		Assert.assertEquals(NewsLetterConfirMsg, ActualSubsText);
		
	}
	
};

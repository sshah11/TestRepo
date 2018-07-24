package helper.testbase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TestBase {

	public static WebDriver driver;
	
	
	public boolean IsElementDisplayed( WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("Element is displayed" + element);
		}
		else {
			System.out.println("Element is not displayed" + element);
			return false;
		}
		return true;
	}
	
	public boolean VerifyTextDisplayed(WebElement element,String Actual) {
		
	 try {
		 	if (element.getText().equalsIgnoreCase(Actual)){
			 return true;
		 	}
		 }
		 catch(Exception e) {
			
			 return false;
			 
		 }
		return true;
	}
		 
	 
		
}


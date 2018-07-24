package helper.pageobjectmodel;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import helper.testbase.TestBase;
import helper.wait.HelperWait;

public class ProductFilterPage {
	
	HelperWait helperwait = new HelperWait();
    WebDriver driver;
    TestBase testbase;
    String SearchPageActualText = "Casual dress";
    
	
	@FindBy(xpath="//form[@id='searchbox']/input[4]")
	WebElement SearchTextBox;
	
	@FindBy(xpath="//form[@id='searchbox']/button")
	WebElement SearchButton;
	
	@FindBy(xpath="//*[@id='center_column']/h1/span[1]")
	WebElement 	SearchPageTextElement;
	
	@FindBy(xpath="//select[@id='selectProductSort']")
	WebElement 	SortBySelectElement;
	

	
	@FindAll({@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")})
	List <WebElement> TotalProductsprice;
	
	
	
	public ProductFilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helperwait.waitForElement(driver, SearchTextBox, 60);
	}
	
	
	public void EnterTextInSearchBox(String searchstring) {
		SearchTextBox.sendKeys(searchstring);
	}
	
	public void ClickSubmit() {
		SearchButton.click();
		
	}
	
	public void SearchPageIsDisplayed() {
		testbase= new TestBase();
		testbase.VerifyTextDisplayed(SearchPageTextElement, SearchPageActualText);
		
	}
	
	public void SelectSortingOrder(String SortOrder) {
		Select select = new Select(SortBySelectElement);
		select.selectByVisibleText(SortOrder);
	}
	
	
	public void VerifySorttiingOrder() throws InterruptedException {

		
		ArrayList<Integer> array = new ArrayList<Integer>();

		Iterator<WebElement> itr = TotalProductsprice.iterator();

		while (itr.hasNext()) {
			String p = itr.next().getText();
			System.out.println(p);
			if (p.contains("$")) {
				String actualData = p.substring(1);
				System.out.println(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}

		}

		for (int i = 0; i < array.size() - 1; i++) {

			if (array.get(i) < array.get(i + 1)) {
				System.out.println("obj.get(i):-" + array.get(i));
				System.out.println("obj.get(i+1):-" + array.get(i + 1));
			} else {
				Assert.assertTrue(false);
			}
		}
	}
}
	
	
	

	

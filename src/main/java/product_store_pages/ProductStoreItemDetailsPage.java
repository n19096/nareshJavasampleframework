package product_store_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

/**
 * Verifying item details and 
 * also it will accept popup and navigate to cart
 * @author naresh.kummari
 *
 */
public class ProductStoreItemDetailsPage extends CommonMethods
{
	// identifying the elements in the page by using find by
	@FindBy(xpath = "//a[text()='Add to cart']")WebElement addToCart;
	@FindBy(xpath = "//a[text()='Cart']")WebElement cartTextLink;
	@FindBy(xpath = "//h2[text()='Samsung galaxy s6']")WebElement item;
	@FindBy(xpath = "//h3[text()='$360']")WebElement itemPrice;
	
	// creating a constructor to initilize the driver
	public ProductStoreItemDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * verifying the item details page and performing click action
	 * the add to cart
	 */
	public void verifyItemDetailsPage()
	{
		String expectedUrl="https://www.demoblaze.com/prod.html?idp_=1";
		String actulaUrl=driver.getCurrentUrl();
		verifying(expectedUrl, actulaUrl);	
	}
	
	public void verifyingItemInItemDetailsPage()
	{
		waitElementVisibility(item);
		boolean itemDisplay = item.isDisplayed();
		String itemPriceDisplay = itemPrice.getText();
		if(itemDisplay==true)
		{
		if(itemPriceDisplay.equals("$360"))
		{
			logger.info("The diaplayed "+item.getText()+" is correct");
	    	test.log(LogStatus.PASS, "The diaplayed "+item.getText()+" is correct");
	    	Assert.fail();
		}
		}
	}
	/**
	 * perfoming click action on the Add to cart button
	 */
	public void clickOnAddToCart()
	{
		clickOnElement(addToCart, "Add to cart ");
	}
	
	/**
	 * printing the text from the popup and accepting the popup
	 * @throws InterruptedException
	 */
	public void popUpHandling() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		logger.info(driver.switchTo().alert().getText());
    	test.log(LogStatus.PASS, driver.switchTo().alert().getText());
		}
		catch (Exception e) {
			logger.error("Alert is not displayed"+e.getMessage());
	    	test.log(LogStatus.FAIL, "Alert is not displayed"+e.getMessage());
		}
		String expectedPopUpMessage=driver.switchTo().alert().getText();
		String ActualPopUpMessage ="Product added.";
		if(expectedPopUpMessage.equals(ActualPopUpMessage))
		{
			logger.info("Displyed popup is right one");
	    	test.log(LogStatus.PASS, "Displyed popup is right one");
	    	driver.switchTo().alert().accept();
		}
	}
	/**
	 * perfoming click action on the cart text link
	 */
	public void clickOnCart()
	{
		clickOnElement(cartTextLink, "Cart Link ");
	}
}

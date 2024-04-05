package product_store_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;
import commoc_methods.ExcelConstraints;

/**
 * Verifying cart page and placing order and verifying the item 
 * printing the order summary
 * @author naresh.kummari
 *
 */
public class ProductStoreCartPage extends CommonMethods
{
	
	// identifying the elements using find by and storing in reference variable
	@FindBy(xpath = "//td[text()='Samsung galaxy s6']")WebElement item;
	@FindBy(xpath = "//td[text()='360']")WebElement itemPrice;
	@FindBy(id = "totalp")WebElement totalPrice;
	@FindBy(id = "totalm")WebElement totalPriceInPlaceOrder;
	@FindBy(xpath = "//button[text()='Place Order']")WebElement placeOrderButton;
	@FindBy(id = "name")WebElement nameField;
	@FindBy(id = "country")WebElement countryField;
	@FindBy(id = "city")WebElement cityField;
	@FindBy(id = "card")WebElement cardField;
	@FindBy(id = "month")WebElement monthField;
	@FindBy(id = "year")WebElement yearField;
	@FindBy(xpath = "//button[text()='Purchase']")WebElement purchaseButton;
	@FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']")WebElement orderedItem;
	@FindBy(xpath = "//button[text()='OK']")WebElement okButton;
	
	//Creating a constructor to initialize the driver
	public ProductStoreCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Verifying the cart page and 
	 * verifying the item is dispalyed or not in the cart
	 * @throws InterruptedException
	 */
	public void cartPageAndItemVarifycation() throws InterruptedException
	{
		String actualUrl="https://www.demoblaze.com/cart.html";
		String expectedUrl=driver.getCurrentUrl();
		verifying(expectedUrl, actualUrl);
		waitElementVisibility(item);
		try {
			boolean itemDisplayed=item.isDisplayed();
			String price=itemPrice.getText();
			String itemTotalPrice=totalPrice.getText();
			if(price.equals("360"))
			{
				if(itemTotalPrice.equals("360"))
				{
			logger.info(item.getText()+" is added to cart ");
	    	test.log(LogStatus.PASS, item.getText()+" is added to cart ");
			}}
		}
		catch (Exception e) {
			logger.error(item.getText()+" is not added to cart ");
	    	test.log(LogStatus.FAIL, item.getText()+" is not added to cart ");
	    	Assert.fail();
		}
	}
	
	
	/**
	 * Ordering the item and 
	 * entering required data in the fields fetching from the excel
	 * @throws Throwable
	 */
	public void placeOrder(int l) throws Throwable
	{
		clickOnElement(placeOrderButton, "Place Order Button ");
		String priceInPlaceOrder=totalPriceInPlaceOrder.getText();
		if(priceInPlaceOrder.equals("360"))
		{
			logger.info("price displayed in place order popup is correct");
	    	test.log(LogStatus.PASS, "price displayed in place order popup is correct");
		}
		sendKeysToElement(nameField, "Name ", fetchExcelData(ExcelConstraints.e3,l));
		sendKeysToElement(countryField, "Country ", fetchExcelData(ExcelConstraints.e4,l));
		sendKeysToElement(cityField, "city ", fetchExcelData(ExcelConstraints.e5,l));
		sendintKeysToElement(cardField, "Card ", fetchExcelintData(ExcelConstraints.e6,l));
		sendKeysToElement(monthField, "Month ", fetchExcelData(ExcelConstraints.e7,l));
		sendintKeysToElement(yearField, "Card ", fetchExcelintData(ExcelConstraints.e8,l));
		clickOnElement(purchaseButton, "Purchase ");
		waitElementVisibility(orderedItem);
		if(orderedItem.getText().contains("Thank you for your purchase!"))
		{
			logger.info(item.getText()+" is ordered successfully");
	    	test.log(LogStatus.PASS, item.getText()+" is ordered successfully");
		}
		else{
			logger.error(item.getText()+" is not ordered successfully");
	    	test.log(LogStatus.FAIL, item.getText()+" is not ordered successfully");
	    	Assert.fail();
		}
		logger.info("Order details "+orderedItem.getText());
    	test.log(LogStatus.PASS, "Order details "+orderedItem.getText());
    	clickOnElement(okButton, "ok button ");
	}
}

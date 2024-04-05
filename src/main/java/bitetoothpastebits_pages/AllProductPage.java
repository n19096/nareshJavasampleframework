package bitetoothpastebits_pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

public class AllProductPage extends CommonMethods
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='card-alt-4738413592681']/descendant::div[@class='p-relative x']") WebElement itemInProductMenu;
	@FindBy(xpath = "//div[text()='Add To Cart']") WebElement itemAddToCart;
	@FindBy(xpath = "//p[text()=' Mouthwash Bits']/ancestor::div[@class='x h-100 align-content-stretch pr-0 p-2 px-md-3 pt-md-2 pb-md-1 f flex-column']/descendant::input")
	WebElement mouthwashBitsCount;
	@FindBy(xpath = "//span[text()='Mouthwash Bits']") WebElement mouthwashBits;
	@FindBy(xpath = "//h5") WebElement backButton;
	
	
	// creating a construct 
		public AllProductPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	/**
	 *Add random products to cart from All products menu
	 */
	public void addProductsFromAllProducts() throws InterruptedException
	{
		// verifying page url with actual url
		String actualUrl="https://bitetoothpastebits.com/collections/all";
		String expectedUrl=driver.getCurrentUrl();
		verifying(expectedUrl, actualUrl);
		
		
		Thread.sleep(3000);
		// performing mouse hover action 
		mouseHoverToElement(itemInProductMenu);
		// adding product to the cart
		clickOnElement(itemAddToCart, "mouth wash Bits");
		Thread.sleep(5000);
		String productCount= mouthwashBitsCount.getAttribute("aria-label");
		// verifying that product is added to cart or not
		try
		{
			mouthwashBits.isDisplayed();
			if(productCount.equals("1"))
			{
			logger.info("mouth wash Bits is added to the cart");
			test.log(LogStatus.PASS, "mouth wash Bits is added to the cart");
			} else
			{
				 logger.error("mouth wash Bits is not added to the cart");
				 test.log(LogStatus.FAIL, "mouth wash Bits is not added to the cart");	
			}
		}
		catch (NoSuchElementException e) 
		{
			 logger.error("mouth wash Bits is not added to the cart");
			 test.log(LogStatus.FAIL, "mouth wash Bits is not added to the cart");
		}
		// performing click action on  back arrow button
		clickOnElement(backButton, "Back button");
	}
}

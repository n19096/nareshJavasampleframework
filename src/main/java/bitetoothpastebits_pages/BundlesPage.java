package bitetoothpastebits_pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

public class BundlesPage extends CommonMethods
{
	WebDriver driver;
	@FindBy(xpath = "//*[@href='/collections/bundles']") WebElement BundlesButton;
	@FindBy(xpath = "//div[@id='card-alt-3645109600361']/descendant::div[@class='p-relative x']") WebElement bundlesProduct;
	@FindBy(xpath = "//div[text()='Add To Cart']") WebElement itemAddToCart;
	@FindBy(xpath = "//p[text()=' The Starter Kit']/ancestor::div[@class='x h-100 align-content-stretch pr-0 p-2 px-md-3 pt-md-2 pb-md-1 f flex-column']/descendant::input")
	WebElement theStarterKitCount;
	@FindBy(xpath = "//span[text()='The Starter Kit']") WebElement theStarterKit;
	@FindBy(xpath = "//h5") WebElement backButton;
	
	// creating a construct 
		public BundlesPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
			
			/**
			 * Add random products to cart from bundles menu
			 * @throws InterruptedException
			 */
			public void addProductsFromBundles() throws InterruptedException
			{	
				Thread.sleep(2000);
				//performing click action on the Bundles button
				clickOnElement(BundlesButton, "Bundles button");
				// verifying page url with actual url
				String actualUrl="https://bitetoothpastebits.com/collections/bundles";
				String expectedUrl=driver.getCurrentUrl();
				verifying(expectedUrl, actualUrl);
				// performing mouse hover action
				mouseHoverToElement(bundlesProduct);
				// adding product to the cart
				clickOnElement(itemAddToCart, "The Starter Kit");
				Thread.sleep(5000);
				String productCount=theStarterKitCount.getAttribute("aria-label");
				// verifying that product is added to cart or not
				try
				{
					theStarterKit.isDisplayed();
					if(productCount.equals("1"))
					{
					theStarterKit.isDisplayed();
					logger.info("The Starter Kit is added to the cart");
					test.log(LogStatus.PASS, "The Starter Kit is added to the cart");
				} else
				{
					 logger.error("The Starter Kit is not added to the cart");
					 test.log(LogStatus.FAIL, "The Starter Kit is not added to the cart");
				}
				}
				catch (NoSuchElementException e) 
				{
					 logger.error("The Starter Kit is not added to the cart");
					 test.log(LogStatus.FAIL, "The Starter Kit is not added to the cart");
				}
				// performing click action on  back arrow button
				clickOnElement(backButton, "Back button");
				Thread.sleep(2000);
			}
			

}

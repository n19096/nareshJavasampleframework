package bitetoothpastebits_pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

public class PersonalCarePage extends CommonMethods 
{
WebDriver driver;

@FindBy(xpath = "//span[text()='Carbon Capture Cleanser']") WebElement carbonCaptureCleanser;
@FindBy(xpath = "//div[text()='Add To Cart']") WebElement itemAddToCart;
@FindBy(xpath = "//div[@id='card-alt-6944067715177']/descendant::div[@class='p-relative x']") WebElement personalCareProduct;
@FindBy(xpath = "//*[@href='/collections/personal-care']") WebElement personalCareButton;
@FindBy(xpath = "//h5") WebElement backButton;
@FindBy(xpath = "//p[text()=' Carbon Capture Cleanser']/ancestor::div[@class='x h-100 align-content-stretch pr-0 p-2 px-md-3 pt-md-2 pb-md-1 f flex-column']/descendant::input")
WebElement carbonCaptureCleanserCount;

//creating a construct 
	public PersonalCarePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		/**
		 * Add random products to cart from personal care menu
		 * @throws InterruptedException
		 */
		public void addProductsFromPersonalCare() throws InterruptedException
		{
			Thread.sleep(2000);
			//performing click action on the Personal care button
			clickOnElement(personalCareButton, "Personal care button");
			// verifying page url with actual url
			String actualUrl="https://bitetoothpastebits.com/collections/personal-care";
			String expectedUrl=driver.getCurrentUrl();
			verifying(expectedUrl, actualUrl);
			// performing mouse hover action
			mouseHoverToElement(personalCareProduct);
			// adding product to the cart
			clickOnElement(itemAddToCart, "Carbon Capture Cleanser");
			Thread.sleep(4000);
			String productCount= carbonCaptureCleanserCount.getAttribute("aria-label");
			// verifying that product is added to cart or not
			try
			{
				carbonCaptureCleanser.isDisplayed();
				if(productCount.equals("1"))
				{
				logger.info("Carbon Capture Cleanser is added to the cart");
				test.log(LogStatus.PASS, "Carbon Capture Cleanser is added to the cart");
				} else
				{
					 logger.error("Carbon Capture Cleanser is not added to the cart");
					 test.log(LogStatus.FAIL, "Carbon Capture Cleanser is not added to the cart");
				}
			}
			catch (NoSuchElementException e) 
			{
				 logger.error("Carbon Capture Cleanser is not added to the cart");
				 test.log(LogStatus.FAIL, "Carbon Capture Cleanser is not added to the cart");
			}
			// performing click action on  back arrow button
			clickOnElement(backButton, "Back button");
			Thread.sleep(2000);
		}

}

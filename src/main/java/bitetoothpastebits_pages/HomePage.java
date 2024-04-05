package bitetoothpastebits_pages;

import java.util.NoSuchElementException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

/**
 * Action which is performed in the bite tooth paste bits
 * @author naresh.kummari
 *
 */
public class HomePage extends CommonMethods
{
	
		WebDriver driver;
	
		//Identifying the elements using find by and storing in the reference variables
		@FindBy(xpath = "//button[@class='needsclick klaviyo-close-form kl-private-reset-css-Xuajs1']") WebElement popUpCloseButton;
		@FindBy(xpath = "//div[text()='Cart']") WebElement cartButton;
		@FindBy(xpath = "//button[@name='checkout']") WebElement checkOutButton;
		@FindBy(xpath = "//div[@class='order-summary']") WebElement summary;
		@FindBy(xpath = "//a[text()=' Shop']") WebElement shopButton;
		
			// creating a construct 
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}	
		
		public void closePopUp()
		{
			try 
			{	
			//performing click action on the pop up close button
		//	clickOnElement(popUpCloseButton, "Pop up close button");
			popUpCloseButton.click();
			
			}catch (NoSuchElementException e) 
			{
				logger.error("There no pop up is displayed");
				test.log(LogStatus.FAIL, "There no pop up is displayed");		
			}
			clickOnElement(shopButton, "shop ");
		}
		/**
		 *  Continue to checkout and view the order summary
		 * @throws InterruptedException
		 */
		public void orderSummary() throws InterruptedException
		{
//			
			clickOnElement(cartButton, "Cart button");
			Thread.sleep(3000);
			clickOnElement(checkOutButton, "Check Out Button");
			Thread.sleep(3000);
			clickOnElement(popUpCloseButton, "Pop up close button");
			Thread.sleep(3000);
			System.out.println(summary.getText());
		}
}

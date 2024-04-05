package demoqaPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

/**
 *  Expand the elements tab if it is in collapsed state and validate
 *   elements tab to be expanded.
 * @author naresh.kummari
 *
 */
public class DemoQaHomePage extends CommonMethods
{
	// creating a construct 
	public DemoQaHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']") WebElement elementTab;
	@FindBy(xpath = "//h5[text()='Forms']") WebElement formsTab;
	@FindBy(xpath = "//div[@class='element-list collapse show']//span[text()='Text Box']") WebElement text1Element;
	@FindBy(xpath = "//div[@class='element-group'][2]//li[@id='item-0']") WebElement text2Element;
	/**
	 * Expand the elements menu  and verifying it is expanded or not
	 * @param driver
	 */
	public void homePageElements()
	{

		// Type casting driver into javascript executor and scrolling 200 pxls
//		customScroll(200);
		JavascriptExecutor scroll= (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,300)");
		Object d = scroll.executeScript("return window.pageYOffset;");
	      System.out.println("Scroll position after scrolling upto an element: "+d);
		
		// driver will wait until the element is clickable and performing click action
		waitElementClickable(elementTab);
		
		// identifying element and performing on it
		clickOnElement(elementTab, "Element tab ");
		
		// verifying that the element is displayed
		boolean textdisplay = text1Element.isDisplayed();
		if(textdisplay==true)
		{
		logger.info("elements tab is expanded");
		test.log(LogStatus.PASS, "elements tab is expanded");
		}
		else
		{
		logger.error("elements tab is not expanded");
		test.log(LogStatus.FAIL, "elements tab is not expanded");
		}
		
	}
	
	/**
	 * Expand the form menu and verifying it is expanded or not
	 * @param driver
	 */
	public void homePageForms()
	{
		// Type casting driver into javascript executor and scrolling 200 pxls
//		customScroll(200);
		JavascriptExecutor scroll= (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,200)");
		Object d = scroll.executeScript("return window.pageYOffset;");
	      System.out.println("Scroll position after scrolling upto an element: "+d);
		
		// driver will wait until the element is clickable and performing click action
		waitElementClickable(elementTab);
		clickOnElement(formsTab, "Froms tab ");
		// verifying that the element is displayed
		waitPresenceElementLocator(By.xpath("//div[@class='element-list collapse show']//span[text()='Practice Form']"));
		boolean textdisplay = text2Element.isDisplayed();
		if(textdisplay==true)
		{
		logger.info("Forms tab is expanded");
		test.log(LogStatus.PASS, "Forms tab is expanded");
		}
		else
		{
		logger.error("Forms tab is not expanded");
		test.log(LogStatus.FAIL, "Forms tab is not expanded");
		}
		// performing click action on the forms button
		clickOnElement(text2Element, "practice Form button");
	}
}

package pagesOrangeHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoc_methods.CommonMethods;

/**
 * Verify user logged into dashboard page successfully.
 * @author naresh.kummari
 *
 */
public class DashBoard extends CommonMethods
{
	// identifying element using findby
	@FindBy(xpath = "//span[text()='Directory']")
	WebElement element;
	
	public DashBoard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Verify user logged into dashboard page successfully.
	public void dashboardVerifyAndClickDirectory()
	{
		// comparing actual url with expected url to verify the page
		String actualResults="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String	expetedResults=driver.getCurrentUrl();
		verifying(expetedResults, actualResults);
		
		// Performing click action on the directory element
		clickOnElement(element, "Directory");	
	}
}

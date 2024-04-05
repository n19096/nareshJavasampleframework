package pagesOrangeHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoc_methods.CommonMethods;

/**
 * Click on profile icon and select Logout.
 * Validate user got logged out successfully
 * @author naresh.kummari
 *
 */
public class LogoutHrm extends CommonMethods
{
	// identifying the elements using find by
	@FindBy (xpath = "//span[@class='oxd-userdropdown-tab']")WebElement profileIcon;
	@FindBy (xpath = "//a[text()='Logout']")WebElement logOut;
	
	public LogoutHrm(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click on profile icon and select Logout.
	// Validate user got logged out successfully
	public void logoutHrm()
	{
	
		// performing click action on the profile icon
		   clickOnElement(profileIcon, "profileIocn");
		   
		   // performing click action on the logout button
		   clickOnElement(logOut, "LogOutText");
		   
		   // verifying that the user  log out
		   String expextedResult ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		   
		   String actualResult =driver.getCurrentUrl();
		   
		   // verifying actual url with current url after logout
		   verifying(expextedResult, actualResult);
	}
}

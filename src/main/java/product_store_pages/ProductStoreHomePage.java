package product_store_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoc_methods.CommonMethods;

/**
 * performing click actions on the signup and login buttons
 * @author naresh.kummari
 *
 */
public class ProductStoreHomePage extends CommonMethods
{

// identifying the elements in the page by using find by
@FindBy(xpath = "//a[text()='Sign up']") WebElement signUpLink;
@FindBy(xpath = "//a[text()='Log in']") WebElement logInLink;
@FindBy(xpath = "//a[text()='Log out']") WebElement logOutLink;

public ProductStoreHomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
 
/**
 * performing click action on the signup link text
 * @throws Throwable
 */
public void signUplinkclickAction() throws Throwable
{
	clickOnElement(signUpLink, "Sign up Link ");	
}
/**
 * performing click action on the login  link text
 * @throws Throwable
 */
public void logInlinkclickAction() throws Throwable
{
	clickOnElement(logInLink, "Log in Link ");	
}

/**
 * performing click action on the logout  link text
 * @throws Throwable
 */
public void logOutlinkclickAction() throws Throwable
{
	clickOnElement(logOutLink, "Log Out Link ");	
}
}

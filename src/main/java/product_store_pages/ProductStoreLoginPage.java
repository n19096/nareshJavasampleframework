package product_store_pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;
import commoc_methods.ExcelConstraints;

/**
 * logging into the page by using the credentials and entering data from excel
 * @author naresh.kummari
 *
 */
public class ProductStoreLoginPage extends CommonMethods
{
	
	// identifying the elements by using findby
	@FindBy(id = "loginusername") WebElement UsernameField;
	@FindBy(xpath = "//input[@id='loginpassword']") WebElement passwordField;
	@FindBy(xpath = "//button[text()='Log in']") WebElement logInButton;
	@FindBy(xpath = "//button[text()='Log in']") WebElement welcome;//a[text()='Samsung galaxy s6']
	@FindBy(id = "nameofuser") WebElement userDetails;
	@FindBy(xpath = "//a[text()='Samsung galaxy s6']") WebElement product;

	public ProductStoreLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	/**
	 * Sending or entering keys in the username and password field
	 * and also performing click action on the  login button
	 * @throws Throwable
	 */
	public void logInAction(int l) throws Throwable
	{
		sendKeysToElement(UsernameField, "username field", fetchExcelData(ExcelConstraints.e1,l));
		sendKeysToElement(passwordField, "password field", fetchExcelData(ExcelConstraints.e2,l));
		clickOnElement(logInButton, " LogIn button ");
	}
	
	/**
	 * verifying the logined user is correct or nor
	 * @throws Throwable
	 */
	public void verifyUser() throws Throwable
	{
		try 
		{
			Thread.sleep(2000);
			boolean user=userDetails.isDisplayed();
			if(user==true)
			{
			logger.info(" User succesfully loged In");
	    	test.log(LogStatus.PASS, " User succesfully loged In");
			}
		}
		catch (Exception e) 
		{
			logger.error(" User failed to log In");
	    	test.log(LogStatus.FAIL, " User failed to log In");
	    	Assert.fail();
		}
	}
	
	/**
	 * selecting the random product in the page
	 */
	public void selectItem()
	{
		waitElementClickable(product);
		clickOnElement(product, product.getText());
	}
}

package product_store_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;
import commoc_methods.ExcelConstraints;

public class ProductStoreSignupPage extends CommonMethods
	{

	@FindBy(id = "sign-username") WebElement signUsernameField;
	@FindBy(xpath = "//input[@id='sign-password']") WebElement signpasswordField;
	@FindBy(xpath = "//button[text()='Sign up']") WebElement signUpButton;

	public ProductStoreSignupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	public void signUpAction(int l) throws Throwable
	{
		sendKeysToElement(signUsernameField, "UserName field", fetchExcelData(ExcelConstraints.e1,l));
		sendKeysToElement(signpasswordField, "password field", fetchExcelData(ExcelConstraints.e2,l));
		clickOnElement(signUpButton, " Sign up button ");
		waitAlertPresence();
		logger.info(driver.switchTo().alert().getText());
    	test.log(LogStatus.PASS, driver.switchTo().alert().getText());
    	Assert.fail();
		driver.switchTo().alert().accept();
	}
}

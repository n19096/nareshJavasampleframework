package pagesOrangeHrm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoc_methods.CommonMethods;

public class orangePomLogin extends CommonMethods
{
	// Identifying fields and button in page by using find by 
	@FindBy(name = "username")WebElement userName;
	@FindBy(name = "password")WebElement password;
	@FindBy(xpath = "//button[@type='submit']")WebElement submit;
	
	// initializing page factory
	public orangePomLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// returing user name to required methods
	public WebElement userNamereturn()
	{
		return userName;
	}
	// returing password to required methods
	public WebElement passwordreturn()
	{
		return password;
	}
	public WebElement submitreturn()
	{
		return submit;
	}
	
	// entering keys in the user name fields ane verifying the text
	public void setUserName(String uname) throws Throwable
	{
		sendKeysToElement(userNamereturn(), "UserName field", uname);
	}
	// entering keys in the password fields ane verifying the text
	public void setPassword(String pwd) throws Throwable
	{
		sendKeysToElement(passwordreturn(), "PasswordField", pwd);
	}
	// perforing click action on the submit button
	public void clickOnLogin()
	{
		clickOnElement(submitreturn(), "Login Button");
	}}


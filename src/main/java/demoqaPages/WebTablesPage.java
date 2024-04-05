package demoqaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

/**
 * actions which is performed in the webtablepage
 * @author naresh.kummari
 *
 */
public class WebTablesPage extends CommonMethods
{
	
	// using findby and pom identifiny the elements
	@FindBy (id = "firstName") WebElement firstName;
	@FindBy (id = "lastName") WebElement lastName;
	@FindBy (id = "userEmail") WebElement email;
	@FindBy (id = "age") WebElement age;
	@FindBy (id = "salary") WebElement salary;
	@FindBy (id = "department") WebElement department;
	@FindBy (id = "submit") WebElement submit;
	@FindBy (xpath = "//div[text()='naresh']") WebElement verifyFirstname;
	@FindBy (xpath = "//div[text()='kummari']") WebElement verifylastname;
	@FindBy (xpath = "//span[text()='Web Tables']") WebElement webTableElement;
	@FindBy (xpath = "//button[text()='Add']") WebElement addElement;
	@FindBy (xpath = "//div[text()='naresh']/ancestor::div[@role='row']//span[@title='Delete']") WebElement deleteButton;
	
	
	// creating a construct 
	public WebTablesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Expand the elements menu bar and Select Web Tables
	 * @param driver
	 */
	public void WebTablesButtonAndPage()
	{
		clickOnElement(webTableElement, "Web Element");
		waitPresenceElementLocator(By.xpath("//button[text()='Add']"));
		clickOnElement(addElement, "Add button");
	}
	
	// sending keys to the field by  using custom method
	public void setFirstName(String fname) throws Throwable
	{
		sendKeysToElement(firstName, "first name", fname);
	}
	// sending keys to the field by  using custom method
	public void setlastName(String lname) throws Throwable
	{
		sendKeysToElement(lastName, "last name", lname);
	}
	// sending keys to the field by  using custom method
	public void setuserEmail(String emailname) throws Throwable
	{
		sendKeysToElement(email, "user Email", emailname);
	}
	// sending keys to the field by  using custom method
	public void setAge(String Userage) throws Throwable
	{
		sendKeysToElement(age, "age", Userage);
	}
	// sending keys to the field by  using custom method
	public void setSalary(String userSalary) throws Throwable
	{
		sendKeysToElement(salary, "salary", userSalary);
	}
	// sending keys to the field by  using custom method
	public void setDepartment(String userDepartment) throws Throwable
	{
		sendKeysToElement(department, "department", userDepartment);
	}
	// performing click action on element by  using custom method
	public void clickOnSubmit()
	{
		clickOnElement(submit, "submit");
	}
	
	/**
	 * Verify a new record got created within the table
	 */
	public void VerifyStoredData()
	{
		// identifying element and storing in the reference
		
		// verifying that the elements is displayed
		Boolean actualfirst = verifyFirstname.isDisplayed();
		Boolean actualLast = verifylastname.isDisplayed();
		// verifying that the data is created or not
		if(actualfirst.equals(true))
		{
			if(actualLast.equals(true))
			{
				
				logger.info("new record got created within the table");
				test.log(LogStatus.PASS, "new record got created within the table");
			}
			else
			{
				logger.error("no record created within the table");
				test.log(LogStatus.FAIL, "no record created within the table");
			}
		}
	}
		
	
	/**
	 * Click on Delete option of the newly created record and validate delete operation
	 */
	public void deleteRecordAndVerify()
	{
		clickOnElement(deleteButton, "Delete button");
		try
		{
			// verifying that the elements is displayed
			WebElement deletedFirstname=driver.findElement(By.xpath("//div[text()='naresh']"));
			WebElement deletedLastname=driver.findElement(By.xpath("//div[text()='kummari']"));
			Boolean actualfirst = deletedFirstname.isDisplayed();
			Boolean actualLast = deletedLastname.isDisplayed();
			if(actualfirst.equals(true))
			{
				if(actualLast.equals(true))
				{
					
					logger.info("Data is not deleted");
					test.log(LogStatus.PASS, "Data is not deleted");
				}
			}
		}
		catch (Exception e) 
		{
			logger.info("Data got deleted"+" "+e.getMessage());
			test.log(LogStatus.PASS, "Data got deleted"+" "+e.getMessage());
		}
	}
}

package demoqaPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

/**
 * Expand the Forms menu bar and select Practice Form
 * Fill in the details under Student Registration Form and click on Submit
 * @author naresh.kummari
 *
 */
public class DemoqaFormsPage extends CommonMethods
{
	// creating a construct 
	public DemoqaFormsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// using findby identifying the elements and storing refrences
	@FindBy(id = "firstName") WebElement firstname;
	@FindBy(id = "lastName") WebElement lastName;
	@FindBy(id = "userEmail") WebElement userEmail;
	@FindBy(xpath = "//label[@for='gender-radio-1']") WebElement genderMale;
	@FindBy(xpath = "//label[@for='gender-radio-2']") WebElement genderFemale;
	@FindBy(xpath = "//label[@for='gender-radio-3']") WebElement genderOther;
	@FindBy(id = "userNumber") WebElement userPhNumber;
	@FindBy(id = "dateOfBirthInput") WebElement dateOfBirth;
	@FindBy(id = "subjectsInput") WebElement subject;
	@FindBy(xpath = "//label[@for='hobbies-checkbox-1']") WebElement HobbieSports;
	@FindBy(xpath = "//label[@for='hobbies-checkbox-2']") WebElement HobbieReading;
	@FindBy(xpath = "//label[@for='hobbies-checkbox-3']") WebElement HobbieMusic;
	@FindBy(id = "uploadPicture") WebElement uploadPicture;
	@FindBy(id = "currentAddress") WebElement currentAddress;
	@FindBy(id = "state") WebElement state;
	@FindBy(id = "react-select-3-option-1") WebElement selectSate;
    @FindBy(id = "city") WebElement city;
    @FindBy(id = "react-select-4-option-0") WebElement selectCity;
	@FindBy(id = "submit") WebElement submit;
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']") WebElement yearlist;	
	@FindBy(xpath = "//select[@class='react-datepicker__month-select']") WebElement monthlist;
	@FindBy(xpath = "//div[text()='Thanks for submitting the form']") WebElement finalText;
	@FindBy(xpath = "//div[@class=' css-11unzgr']") List<WebElement> stateList;
	@FindBy(id = "MYlastName") WebElement mylastname;
	
	/**
	 *  sending keys to the field by  using custom method
	 * @param fname
	 * @throws Throwable 
	 */
	public void setFirstName(String fname) throws Throwable
	{
		sendKeysToElement(firstname, "first name", fname);
	}
	/**
	 *  sending keys to the field by  using custom method
	 * @param lname
	 * @throws Throwable 
	 */
	public void setlastName(String lname) throws Throwable
	{
		sendKeysToElement(lastName, "last name", lname);
	}
	/**
	 *  sending keys to the field by  using custom method
	 * @param emailname
	 * @throws Throwable 
	 */
	public void setuserEmail(String emailname) throws Throwable
	{
		sendKeysToElement(userEmail, "user Email", emailname);
	}
	
	/**
	 *  performing click action on the male gender radio buttons
	 */
	public void setGenderMale()
	{
		clickOnElement(genderMale, "Male radio button");
	}
	/**
	 *  performing click action on the female gender radio buttons
	 */
	public void setGenderFemale()
	{
		clickOnElement(genderFemale, "Female radio button");
	}
	/**
	 *  performing click action on the other gender radio buttons
	 */
	public void setGenderOther()
	{
		clickOnElement(genderOther, "other radio button");
	}
	/**
	 * sending keys to the field by  using custom method
	 * @param userphNumber
	 * @throws Throwable 
	 */
	public void setUserPhNumber(String userphNumber) throws Throwable
	{
		sendKeysToElement(userPhNumber, "phone number ", userphNumber);
	}
	
	/**
	 * sending keys to the field by  using custom method
	 * And selecting subject using robot class
	 * @param Subject
	 * @throws Throwable 
	 */
	public void setSubject(String Subject) throws Throwable
	{
		// sending keys to the subject field and verifying the selected data
		sendKeysToElement(subject, "department", Subject);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Selecting data in the calendar using select class
	 * @param year
	 * @param month
	 * @param day
	 * @throws Throwable
	 */
	public void setDateOfBirth(String year,int month,String day) throws Throwable//div[@role='listbox']
	{
		// identifying date of birth dropdown and performing click action
		clickOnElement(dateOfBirth, "Date of birth dropdwn");
		Thread.sleep(2000);
		// selecting the year by using select by value
		try {
	    	Select selectYear = new Select(yearlist);
	    	selectYear.selectByValue(year);
		}
		catch(NoSuchElementException e) 
		{
			// if there is no such element then the following los will be printed
			logger.error("there is no such year like "+year+" "+e.getMessage());
			test.log(LogStatus.FAIL, "there is no such year like "+year+" "+e.getMessage());
		}
		// selecting the month by using index value
		try {
			int Month=month-1;
	    	Select selectMonth = new Select(monthlist);
	    	selectMonth.selectByIndex(Month);
		}
	    	catch(NoSuchElementException e) 
			{
	    		// if there is no such element then the following los will be printed
				logger.error("there is no such month "+" "+e.getMessage());
				test.log(LogStatus.FAIL, "there is no such month"+" "+e.getMessage());
			}
	    Thread.sleep(2000);
	    // fetching the input from the user and clicking selecting that date
	   WebElement userdate= driver.findElement(By.xpath("//div[text()='"+day+"']"));
	   clickOnElement(userdate, day);
	// scrolling the page upto 400 pixels
			JavascriptExecutor scroll= (JavascriptExecutor)driver;
			scroll.executeScript("window.scrollBy(0,400)");
			Object d = scroll.executeScript("return window.pageYOffset;");
			logger.info("Scroll position after scrolling upto an element: "+d);
			test.log(LogStatus.PASS, "Scroll position after scrolling upto an element: "+d);
	}
	
	/**
	 *  performing click action on the sports hobbies radio buttons
	 */
	public void setHobbieSport()
	{
		clickOnElement(HobbieSports, "Sports radio button");
	}
	/**
	 * sending keys (path of the picture) to the field by  using custom method
	 * @param userphNumber
	 * @throws Throwable 
	 */
	public void setPicture(String path, String filename) throws Throwable
	{
		// Sending file to the field and verifying yhe file is uploaded or not
		sendPathToElement(uploadPicture, " picture ", path);
		
		if(uploadPicture.getAttribute("value").length()>0)
		{
			logger.info("uploaded file is same");
			test.log(LogStatus.INFO, "uploaded file is same");
		}
		else
		{
			logger.error("uploaded file is different");
			test.log(LogStatus.FAIL, "uploaded file is different");
		}
	}
	/**
	 * sending keys to the address field by  using custom method
	 * @param userphNumber
	 * @throws Throwable
	 */
	public void setCurrentAddress(String address) throws Throwable
	{
		sendKeysToElement(currentAddress, "Current address", address);
	}
	/**
	 * selecting state from the drop down of sate field
	 * @param userphNumber
	 */
	public void setState(String userState) throws Throwable
	{
		// click on the state dropdown
			clickOnElement(state, " State");
			Thread.sleep(1000);
			try {
				// taking state name from the user and selecting that state
					driver.findElement(By.xpath("//div[text()='"+userState+"']")).click();
					logger.info("user successfully selected "+userState);
					test.log(LogStatus.PASS, "user successfully selected "+userState);
			}
			catch(NoSuchElementException e)
			{
				// if there is no similar state is not present the following logs will be printed
				logger.error("there is no State like "+userState+" "+e.getMessage());
				test.log(LogStatus.FAIL, "there is no State like "+userState+" "+e.getMessage());
			}
		}
	
	/**
	 * 
	 * selecting state from the drop down of sate field
	 * @param userphNumber
	 */
	public void setCity(String userCity) throws Throwable
	{
		// click on the city dropdown
			clickOnElement(city, " city drop down");
			Thread.sleep(2000);
		try {
				// taking city name from the user and selecting that city
				driver.findElement(By.xpath("//div[text()='"+userCity+"']")).click();
				logger.info("user successfully selected "+userCity);
				test.log(LogStatus.PASS, "user successfully selected "+userCity);
			}
		catch(NoSuchElementException e)
			{
				// if there is no similar city is not present the following logs will be printed
				logger.error("there is no State like "+userCity+" "+e.getMessage());
				test.log(LogStatus.FAIL, "there is no State like "+userCity+" "+e.getMessage());
			}
	}
	/**
	 * performing click action on the submit button using custom method
	 */
	public void clickOnSubmit()
	{
		city.submit();
		logger.info("user successfully clicked on submit");
		test.log(LogStatus.PASS, "user successfully clicked on submit");
	}
	
	/**
	 * Verifying that the data is submited succesfully or not
	 */
	public void verifydata()
	{
	Boolean textdisplay  = finalText.isDisplayed();
	if(textdisplay==true)
	{
		logger.info(" Data submited successfully");
		test.log(LogStatus.PASS, " Data submited successfully");
	}
	else
	{
		logger.info("Data is not submited successfully");
		test.log(LogStatus.INFO, "Data is not submited successfully");
	}
	}
}

package demoqaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;


/**
 * Open Browser, Navigate to https://demoqa.com/ and select Elements
 * Expand the elements menu bar and Select radio button
 * Validate 'No' to be in disabled state
 * Select the Yes, Impressive and validate the selection
 * @author naresh.kummari
 *
 */
public class RadioButtonPage extends CommonMethods
{
	@FindBy(xpath = "//span[text()='Radio Button']") WebElement radioButtonTab;
	@FindBy(xpath = "//input[@class='custom-control-input disabled']") WebElement noRadioButton;
	@FindBy(xpath = "//label[@for='impressiveRadio']") WebElement impressiveRadioButton;
	@FindBy(xpath = "//label[@for='yesRadio']") WebElement yesRadioButton;
	
	// creating a construct 
	public RadioButtonPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// creating object of launch browser class to access the methods
	CommonMethods lo = new CommonMethods();
	
	/**
	 * Expand the elements menu bar and Select radio button
	 * Validate 'No' to be in disabled state
	 * @param driver
	 */
	public void RadioButtonAndPage()
	{
		// identifying element and storing in the reference and performing click action
		clickOnElement(radioButtonTab, "Radio button tab");
		// verifying that the elements is enabled or not
		if(noRadioButton.isEnabled()==true)
		{
			logger.error("On Radio button is enabled");
			test.log(LogStatus.FAIL, "On Radio button is enabled");
		}
		else
		{
			logger.info("On Radio button is disabled");
			test.log(LogStatus.PASS, "On Radio button is disabled");
		}
	}
	
	/**
	 * Select the Yes, Impressive and validate the selection
	 * @param driver
	 */
	public void selectYesAndImpressiveButton()
	{
		// identifying elements and storing in the reference and performing click action
		clickOnElement(yesRadioButton, "yes radio  button");
		clickOnElement(impressiveRadioButton, "impressive Radio Button");
		
		//Validate 'yes' and impressive radio to be in enabled state
		if(yesRadioButton.isEnabled()==true)
		{
			logger.info("Yes Radio button is enabled");
			test.log(LogStatus.PASS, "Yes Radio button is enabled");
		}
		else
		{
			logger.error("yes Radio button is disabled");
			test.log(LogStatus.FAIL, "yes Radio button is disabled");
		}
		if(impressiveRadioButton.isEnabled()==true)
		{
			logger.info("impressive Radio button is enabled");
			test.log(LogStatus.PASS, "impressive Radio button is enabled");
		}
		else
		{
			logger.error("impressive Radio button is disabled");
			test.log(LogStatus.FAIL, "impressive Radio button is disabled");
		}
	}
}

package pagesOrangeHrm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import commoc_methods.CommonMethods;

/**
 * Enter the name: Linda, click on the directory suggestion "Linda Jane Anderson", select it and click on Search.
Validate the record displayed on page.
 * @author naresh.kummari
 *
 */
public class DirectoryPageAction extends CommonMethods
{
	
	// identifying the elements using find by
	@FindBy (xpath = "//*[@placeholder='Type for hints...']")WebElement element;
	@FindBy (xpath="//button[@type='submit']")WebElement searchelement;	
	@FindBy (xpath = "//p[text()='Linda Jane Anderson ']")WebElement name; 
	@FindBy (xpath = "//div[@role='listbox']") List<WebElement> list;
	@FindBy (xpath="//button[@class='oxd-icon-button']")WebElement dropdown;	
	
	// initializing the element using page factory class
	public DirectoryPageAction(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Enter the name: Linda, click on the directory suggestion "Linda Jane Anderson", select it and click on Search.
	//Validate the record displayed on page.
	public void directorypageActions(String empName,String elename,String actualempName) throws Throwable
	{
		
		clickOnElement(dropdown, "Drop down ");
		// performing send keys action on the element
		sendKeysToElement(element, elename, empName);
		
		// providing delay to the page to get the list
		Thread.sleep(2000);
	    for(WebElement l:list)
	    {
	    	//Retrieving each element and comparing that with expected and performing click action 
	    	if(l.getText().equals(actualempName))
	    	{
	    		l.click();
	    	}
	    }
	    
	    // identifying search element and performing click action on it 
	    clickOnElement(searchelement, "Search button");
	    Thread.sleep(2000);
	    // waiting until the visibility of all elements in the page
	    waitPresenceElementLocator(By.xpath("//p[text()='Linda Jane Anderson ']"));
	    String expectedResult="Linda Jane Anderson";
	   String actualResult= name.getText();
	   
	   // verifying that  the record founded or not
	   verifying(expectedResult, actualResult);
	   
	   
	}
}

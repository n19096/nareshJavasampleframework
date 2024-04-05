package common_templet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commoc_methods.CommonMethods;

public class CommonTemplet extends CommonMethods
{
	public WebDriver driver;
	// creating object of common method class to get all non static methods  
	
	
	@BeforeSuite
	public void ReportCreate()
	{
		// calling initialize of report before suite
		setUpReport();
	}
	
	@BeforeTest
	public void reportStart()
	{
		// calling create of report before test
		creatingTestReport();
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void browser(String browser)
	{
		// launching browser before class because we are using different browers
		driver=lauchingBrowser(browser);	
	}
	
	@Parameters("url")
	@BeforeClass
	public void urlSend(String url) throws Throwable
	{
		// sending url before class because we are using different websites
		sendingUrlToBrowser(url);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		// Using custome close after every test 
		closingBrowser();
	}
	@AfterTest
	public void closeTest()
	{
		endingTest();
	}
	@AfterSuite
	public void eraseReport()
	{
		// flushing the html report after every suit execution
		flushDown();
	}
	
}

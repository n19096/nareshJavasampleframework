package commoc_methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * This class contains all the common action which regularly used in every script
 * @author naresh.kummari
 *
 */
public class CommonMethods 
{	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static  Logger logger;
	public static WebDriver driver;
	public static Properties prop;
	
	public void setUpReport()
	{
		// initialize the ExtentReporter
	    extent = new ExtentReports(System.getProperty("user.dir") +"\\test-output\\extentReport1.html");
	    logger = LogManager.getLogger(getClass().getSimpleName());
	}
	
	
	
	public void creatingTestReport()
	{
		// creating reports based on the class names
		test=extent.startTest(getClass().getSimpleName());
		System.out.println(getClass().getSimpleName());
	}

	public void endingTest()
	{
		extent.endTest(test);
	}
	
	
	public void flushDown()
	{
		// Flush method will write the test in report- This is mandatory step  
		extent.flush();
	}
	
	
	/**
	 * launching of differenrt browser based on the user input
	 * @param browser
	 * @return
	 */
	public WebDriver lauchingBrowser(String browser)
	{
		// Based on the user input following browsers will open firefox, chrome, InternetExplorer and edge.
		    	  try
		    	  {
		    		  if (browser.equalsIgnoreCase("firefox"))
		    		  {
		    		  System.out.println(" Executing on "+browser);
		    		// creating object of EdgeDriver browser
		    		  driver = new FirefoxDriver();
		    		  }
		    		  else if (browser.equalsIgnoreCase("chrome"))
		    		  {
		    		  System.out.println(" Executing on "+browser);
		    		// creating object of EdgeDriver browser
		    		  ChromeOptions options = new ChromeOptions();
		    		  
		    		  options.addArguments("--remote-allow-origins=*");
//		    		  options.addArguments("Incognito");
		    			options.addArguments("disable-infobars");
		    			options.addArguments("start-maximized");
		    		//	options.addArguments("headless");
		    			driver = new ChromeDriver(options);
		    			
		    		  }
		    		  else if (browser.equalsIgnoreCase("InternetExplorerDriver"))
		    		  {
		    		  System.out.println(" Executing on "+browser);
		    		// creating object of EdgeDriver browser
		    		  driver = new InternetExplorerDriver();
		    		  }
		    		  else if (browser.equalsIgnoreCase("edge"))
		    		  {
		    		  System.out.println(" Executing on "+browser);
		    		// creating object of EdgeDriver browser
		    		  driver = new EdgeDriver();
		    		  }
		    		  else 
				      {
		    			  	// if user input is not matched with the above condition the it create an exception
				         throw new IllegalArgumentException("The Browser Type is Undefined");
				       }	
		    		  logger.info(browser+" browser launched successfully");
		    		  test.log(LogStatus.PASS, browser+" browser launched successfully");
		    	  }
		         catch (WebDriverException e)
		    	  {
		        	// if the edge browser then the ececution will stops here only
		        	 logger.error("failed to launch "+browser+" browser "+" "+e.getMessage());
		        	 test.log(LogStatus.FAIL, "failed to launch "+browser+" browser "+" "+e.getMessage());
		        	 Assert.fail();
		    	  }
		return driver;
	}
	
	
	
//	/**
//	 * performing maximize action on the window and verifying that it is maximize or not
//	 * @throws InterruptedException
//	 */
//	public void customMaximize() throws InterruptedException
//	{
//		// default window sizes
//		int X=1463, Y=792;
//		//performing maximize action on the window
//		try
//		{
//			driver.manage().window().maximize();
//				//size of window after maximize
//			Dimension size = driver.manage().window().getSize();
//			int x =size.getWidth();
//			int y=size.getHeight();
//				// Verify maximize window size with default window size
//      if(x==X)
//      		{
//    	  		if(y==Y)
//    	  		{
//    	  			logger.info("window maximized succefully");
//    	  			test.log(LogStatus.PASS, "window maximized succefully"); 
//    	  		}
//      		}
//      else
//      		{
//    	  		// if the window is not maximize then the execution will stops here 
//    	  		logger.error("failed to maximized window");
//    	  		test.log(LogStatus.FAIL, "failed to maximized window");
//    	  		Assert.fail();
//      		} 
//		}
//		catch (Exception e)
//		{
//			 logger.error("failed to maximized window");
//			  test.log(LogStatus.FAIL, "failed to maximized window");
//			  Assert.fail();
//		}
//	}
	
	
	
	/**
	 * sending url to the browser and verifying url after lauch
	 * @param url
	 * @throws InterruptedException
	 */
	public void sendingUrlToBrowser(String url) throws InterruptedException
	{
		try
		{
		driver.get(url);
		}
		catch (Exception e) 
		{
			logger.error(url+"URl Verification is failed"+e.getMessage());
        	test.log(LogStatus.FAIL, url+"URl Verification is failed "+e.getMessage());
        	Assert.fail();
		}
//		 customMaximize();
	     String actualUrl = url;
	     String expectedUrl=driver.getCurrentUrl();
	       // verifying actual url with expected url
	     verifying(expectedUrl, actualUrl);
	}
	
	
	/**
	 * provide wait until the element is clickable
	 * @param element
	 */
	public void	waitElementClickable(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (TimeoutException e) 
		{
			logger.error(element+" is not clickable "+e.getMessage());
        	test.log(LogStatus.FAIL, element+" is not clickable "+e.getMessage());
		}
	}
	
	
	/**
	 * provide wait until the element is visible
	 * @param element
	 */
	public void	waitElementVisibility(WebElement element)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (TimeoutException e) 
		{
			logger.error(element+" is not visible "+e.getMessage());
			test.log(LogStatus.FAIL, element+" is not visible "+e.getMessage());
		}
	}
	
	
	/**
	 * provide wait until the alret is displayed
	 * @param element
	 */
	public void waitAlertPresence()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		}
		catch (TimeoutException e) 
		{
			logger.error("Alert is not present "+e.getMessage());
			test.log(LogStatus.FAIL, "Alert is not present "+e.getMessage());
		}
	}
	
	
	/**
	 * provide wait until the element is present
	 * @param element
	 */
	public void waitPresenceElementLocator(By element)
	{
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		}
		catch (TimeoutException e) 
		{
			logger.error(element+" is not present "+e.getMessage());
			test.log(LogStatus.FAIL, element+" is not present "+e.getMessage());
		}
	}
	
	
	/**
	 * performing click on the elemnet it will take inputs as webelement and element name
	 * @param element
	 * @param elename
	 */
	public void clickOnElement(WebElement element, String elename)
	{
		try
		{
			// provide wait until the element is clickable and performing click action
			waitElementClickable(element);
			element.click();
			logger.info("User successfully clicked on "+elename);
			test.log(LogStatus.PASS, "User successfully clicked on "+elename);
		}
		catch (ElementClickInterceptedException e)
		{
			// if element is not clickable then execution will stop
			logger.error("User unable to click on "+elename+" "+e.getMessage());
			test.log(LogStatus.FAIL, "User unable to click on "+elename+" "+e.getMessage());
			Assert.fail();
		}
		
	}
	
	
	/**
	 * Sending keys to the fileds and verify the entered keys are correct or not 
	 * and take input as webelement, element name and values
	 * @param element
	 * @param elename
	 * @param keys
	 * @throws Throwable
	 */
	public void sendKeysToElement(WebElement element, String elename, String keys) throws Throwable
	{
		
	//provide wait until the element is visible and perform sendkeys action
		waitElementVisibility(element);
		try
		{
		element.sendKeys(keys);
		logger.info("User send "+keys+" text to the "+elename+" field");
		test.log(LogStatus.PASS, "User send "+keys+" text to the "+elename+" field");
		Thread.sleep(1000);
		}
		catch (Exception e) {
			logger.error("user unable to send keys to "+elename);
			test.log(LogStatus.FAIL, "user unable to send keys to "+elename);
			Assert.fail();
		}
		// verifying the entered keys are correct or not 
		String value=element.getAttribute("value");
		if(value.equals(keys))
		{
			logger.info(value+" is matched with "+keys+" in "+elename);
			test.log(LogStatus.PASS, value+" is matched with "+keys+" in "+elename);
		}
		else
		{
			logger.error(value+" is not matched with "+keys+" in "+elename);
			test.log(LogStatus.FAIL, value+" is not matched with "+keys+" in "+elename);
			Assert.fail();
		}
	}
	
	
	/**
	 * performing scroll action on the page
	 * it will take input number
	 * it will scroll only in y-direction
	 * @param y
	 */
	public void customScroll(int y)
	{
		int a=0;
		// typecasting driver to javascripexecutor to perform scroll using java script
		JavascriptExecutor scroll= (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy+(0,"+y+")");
		// getting how much it was scrolled
		double d =   (Double) scroll.executeScript("return window.pageYOffset;");
		// Verifying it was scrolled or not
		if(d<a)
		{
			logger.info("Scroll position after scrolling upto an element: "+d);
			test.log(LogStatus.PASS, "Scroll position after scrolling upto an element: "+d);	
		}
		else
		{
			logger.error("user unable to scroll page");
			test.log(LogStatus.FAIL, "user unable to scroll page");	
		}     
	}
	
	
	/**
	 * Verifying to string value
	 * @param expectedResult
	 * @param actualResult
	 */
	public void verifying(String expectedResult, String actualResult)
	{
		// if the 2 values is same then the following statements will print
		if(expectedResult.equals(actualResult))
		{
			logger.info(actualResult+" Verifycation is done successfully");
			test.log(LogStatus.PASS, actualResult+" Verifycation is done successfully");	
		}
		else
		{
			// if the valua is not matched then the execution will stop
			logger.error(actualResult+" Verifycation is failed");
			test.log(LogStatus.FAIL, actualResult+" Verifycation is failed");	
			Assert.fail();
		}
	}
	
	public void verifyingInteger(int expectedResult, int actualResult)
	{
		// if the 2 values is same then the following statements will print
		if(expectedResult==actualResult)
		{
			logger.info(actualResult+" Verifycation is done successfully");
			test.log(LogStatus.PASS, actualResult+" Verifycation is done successfully");	
		}
		else
		{
			// if the valua is not matched then the execution will stop
			logger.error(actualResult+" Verifycation is failed");
			test.log(LogStatus.FAIL, actualResult+" Verifycation is failed");	
			Assert.fail();
		}
		
	}
	
	/**
	 * Sending file to the file input field and verifying the uploaded file is same or not
	 * @param element
	 * @param elename
	 * @param keys
	 * @throws Throwable
	 */
	public void sendPathToElement(WebElement element, String elename, String keys) throws Throwable
	{
			waitElementVisibility(element);
		try
		{
			element.sendKeys(keys);
			logger.info("User successfully send "+keys+" file in the "+elename+" field");
			test.log(LogStatus.PASS, "User successfully send "+keys+" file in the "+elename+" field");
			Thread.sleep(1000);
		}
		catch (Exception e) 
		{
			logger.error("User failed to send "+keys+" file in the "+elename+" field"+e.getMessage());
			test.log(LogStatus.FAIL, "User failed to send "+keys+" file in the "+elename+" field"+e.getMessage());
			Assert.fail();
		}
	}

	
	/**
	 * custome close action here we are closing browser and verifying that it is closed or not
	 */
	public void closingBrowser() 
	{
			// getting window handle
			String beforeclose =driver.getWindowHandle();
			String afterClose = null;
			// perfoming close  action on the window
			driver.close();
		try
		{
			// if there is no browser is present then the execution will stops
			afterClose =	driver.getWindowHandle();
			logger.error("user unable close browser ");
			test.log(LogStatus.FAIL, "user unable close browser ");
			Assert.fail();
		}
		catch (NoSuchWindowException e) 
		{
			 logger.info("user closed browser successfully "+e.getMessage());
			 test.log(LogStatus.FAIL, "user closed browser successfully"+e.getMessage());
		}
		if(beforeclose.equals(afterClose))
		{
			 logger.info("user closed browser successfully");
			 test.log(LogStatus.FAIL, "user closed browser successfully");
		}
		else 
		{
			logger.error("user unable close browser ");
			test.log(LogStatus.FAIL, "user unable close browser ");
			Assert.fail();
		}
	}
	
		public void mouseHoverToElement(WebElement element) throws InterruptedException
		{
			Actions ac= new Actions(driver);
			ac.moveToElement(element).perform();
			Thread.sleep(3000);
		}
		
		public String customScreenShot()
		{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =(TakesScreenshot)driver;
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile=new File(System.getProperty("user.dir")+"\\test-output\\screenshots\\"+System.currentTimeMillis()+".png");
			//Copy file at destination
			String path =DestFile.getAbsolutePath();
			try {
				Files.copy(SrcFile, DestFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
		
		public String fetchExcelData(String rowValue, int l) throws Throwable {
			
			String data = null;
			fetchingPropertiesfile();
			// path of the folder
			String path="src\\test\\resources\\"+CommonMethods.prop.getProperty("Filename");
			//moving to that path
			FileInputStream inputdata = new FileInputStream(path);
			
			// Taking control of the file
			Workbook wb=WorkbookFactory.create(inputdata);
			
			// Taking control of the particular sheet sheet.getRow(i)
			Sheet sheet=wb.getSheet(CommonMethods.prop.getProperty("SheetName"));
			
			Row row= sheet.getRow(0);
			
				for(int i=0;i<=row.getLastCellNum();i++)
			    {
			    if(rowValue.equals(sheet.getRow(0).getCell(i).getStringCellValue()))
			    {
			    	String j=CommonMethods.prop.getProperty("TestData");
			    data=sheet.getRow(l).getCell(i).getStringCellValue();

			    break;
			    }}
			
			wb.close();
			return data;
		}	
public double fetchExcelintData(String rowValue,int l) throws Throwable {
			
			double data = 0;
			fetchingPropertiesfile();
			// path of the folder
			String path="src\\test\\resources\\"+CommonMethods.prop.getProperty("Filename");
			
			//moving to that path
			FileInputStream inputdata = new FileInputStream(path);
			
			// Taking control of the file
			Workbook wb=WorkbookFactory.create(inputdata);
			
			// Taking control of the particular sheet
			Sheet sheet=wb.getSheet(CommonMethods.prop.getProperty("SheetName"));
		
			 Row row= sheet.getRow(0);
				
				for(int i=0;i<=row.getLastCellNum();i++)
			    {
			    if(rowValue.equals(sheet.getRow(0).getCell(i).getStringCellValue()))
			    {String j=CommonMethods.prop.getProperty("TestData");
			    data=sheet.getRow(l).getCell(i).getNumericCellValue();
			    break;
			    }}
			wb.close();
			return data;
		}

public void sendintKeysToElement(WebElement element, String elename, double keys) throws Throwable
{
	
//provide wait until the element is visible and perform sendkeys action
	waitElementVisibility(element);
	try
	{
		
		int i=(int) keys;
		String s=i+"";
	element.sendKeys(s);
	logger.info("User send "+keys+" text to the "+elename+" field");
	test.log(LogStatus.PASS, "User send "+keys+" text to the "+elename+" field");
	Thread.sleep(1000);
	}
	catch (Exception e) {
		logger.error("user unable to send keys to "+elename);
		test.log(LogStatus.FAIL, "user unable to send keys to "+elename);
		Assert.fail();
	}
}


public Properties fetchingPropertiesfile() throws Throwable
{
	String propFile = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	File file = new File(propFile);
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	prop = new Properties();
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}

}
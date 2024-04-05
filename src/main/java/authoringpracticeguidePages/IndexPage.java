package authoringpracticeguidePages;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

public class IndexPage extends CommonMethods
{	
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@aria-label='Choose Date']") WebElement calendar;
	@FindBy(xpath = "//button[@class='prev-year']") WebElement preYearArrow;//input[@id='id-textbox-1']
	@FindBy(xpath = "//button[@class='next-year']") WebElement nextYearArrow;
	@FindBy(xpath = "//button[@type='button']") WebElement calenderFiled;
	
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Under the Date field, click on the calendar icon
	 * @throws Throwable
	 */
	public void calendarSelection() throws Throwable
	{
//		Type casting driver into javascript executor and scrolling 200 pxls
	//	customScroll(500);
		JavascriptExecutor scroll= (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,600)");
		Object d = scroll.executeScript("return window.pageYOffset;");
		logger.info("Scroll position after scrolling upto an element: "+d);
		test.log(LogStatus.PASS, "Scroll position after scrolling upto an element: "+d);
	
	      Thread.sleep(1000);
		// driver will wait until the element is clickable and performing click action
		clickOnElement(calendar, "calendar");
	}
	
	/**
	 *  Based on users input, the code should select the appropriate yaer(applicable for past and future year)
	 * @param year
	 */
	public void yearSelection(int year)
	{
		
		int currentYear=Year.now().getValue();
		if(year <currentYear)
		{
			int n= currentYear-year;
			for(int i=1;i<=n;i++)
			{
			currentYear--;
			clickOnElement(preYearArrow, "Year prevoius arrow button and year displayed in the calendar is "+currentYear);
			
			
			}
		}
		if(year >currentYear)
		{
			int n= year-currentYear;
			for(int i=1;i<=n;i++)
			{
				currentYear++;
				clickOnElement(nextYearArrow, "Year next arrow button and year displayed in the calendar is "+currentYear);
			}
		
		}
		
	}
	
	/**
	 *  Based on users input, the code should select the appropriate month(applicable for past and future month)
	 * @param month
	 * @throws InterruptedException
	 */
	public void monthSelect(String month) throws InterruptedException
	{
		Month currentMonth =LocalDate.now().getMonth();
//		WebElement wb= driver.findElement(By.xpath("//h2[@class='month-year']"));
//		String getmonth=wb.getText();
		for(int i=1;i<=12;i++)
		{
			WebElement monthField = driver.findElement(By.xpath("//h2[@class='month-year']"));
			String getmonth=monthField.getText();
			logger.info("User changed the month to "+getmonth);
			test.log(LogStatus.PASS, "user selected "+i+" date");
		if(getmonth.contains(month))
		{
			break;
		}
		else 
		{
			WebElement wb1= driver.findElement(By.xpath("//h2[@class='month-year']"));
			String wb2=wb1.getText();
			driver.findElement(By.cssSelector("[class='next-month']")).click();
			Thread.sleep(1000);
			
		}}
	}

	/**
	 *  Based on users input, the code should select the appropriate date(applicable for past and future dates)
	 * @param i
	 */
	public void dateSelection(String i)
	{
	List<WebElement> date=	driver.findElements(By.xpath("//td"));
	for(WebElement w:date)
	{
		String s=w.getText();
		if(s.equals(i))
		{
			w.click();
			logger.info("user selected "+i+" date");
			test.log(LogStatus.PASS, "user selected "+i+" date");
		}
	}
	logger.info("user "+calenderFiled.getAttribute("aria-label"));
	test.log(LogStatus.PASS, "user "+calenderFiled.getAttribute("aria-label"));
	}
}


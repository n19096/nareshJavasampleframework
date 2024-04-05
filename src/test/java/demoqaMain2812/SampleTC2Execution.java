package demoqaMain2812;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import authoringpracticeguidePages.IndexPage;
import common_templet.CommonTemplet;

/**
 * Navigate to https://www.w3.org/WAI/ARIA/apg/example-index/dialog-modal/datepicker-dialog
 * Under the Date field, click on the calendar icon
 * Based on users input, the code should select the appropriate date(applicable for past and future dates)
 * Verify the desired date got selected
 * @author naresh.kummari
 *
 */
public class SampleTC2Execution extends CommonTemplet
{
	@Test(priority = 1)
	public void selectdate() throws Throwable
	{
		// creating object of index page to call non static methods
		IndexPage ip = new IndexPage(driver);
		ip.calendarSelection();
		ip.yearSelection(2040);
		ip.monthSelect("June");
		ip.dateSelection("19");
		
	}
}

package demoqaMain;


import org.testng.annotations.Test;

import common_templet.CommonTemplet;
import demoqaPages.DemoQaHomePage;
import demoqaPages.WebTablesPage;

/**
 * Navigate to https://demoqa.com/ and select Elements
 * Expand the elements menu bar and Select Web Tables
 * Click on Add
 * Fill in the details on displayed form and click on Submit
 * Verify a new record got created within the table
 * Click on Delete option of the newly created record and validate delete operation
 * @author naresh.kummari
 *
 */
public class DemoqaMainTC2 extends CommonTemplet
{
	// creating a method for demoqa home page
	@Test
	public void dataCration() throws Throwable
	{
		// creating object of Demoqa home page to access the methods of that class and calling the methods
		DemoQaHomePage dh=new DemoQaHomePage(driver);
		dh.homePageElements();

		// creating object of PomLogin to access the methods of that class and calling the methods
		WebTablesPage wp = new WebTablesPage(driver);
		wp.WebTablesButtonAndPage();
		wp.setFirstName("naresh");
		wp.setlastName("kummari");
		wp.setAge("33");
		wp.setSalary("45435");
		wp.setDepartment("QE");
		wp.setuserEmail("nareshshalivahana1999@gmail.com");
		wp.clickOnSubmit();
		wp.VerifyStoredData();
		wp.deleteRecordAndVerify();
	}
}

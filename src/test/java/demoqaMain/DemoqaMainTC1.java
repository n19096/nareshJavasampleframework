package demoqaMain;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commoc_methods.CommonMethods;
import common_templet.CommonTemplet;
import demoqaPages.DemoQaHomePage;
import demoqaPages.RadioButtonPage;
import common_templet.CommonTemplet;

/**
 * Open Browser, Navigate to https://demoqa.com/ and select Elements
 * Expand the elements menu bar and Select radio button
 * Validate 'No' to be in disabled state
 * Select the Yes, Impressive and validate the selection
 * @author naresh.kummari
 *
 */

public class DemoqaMainTC1 extends CommonTemplet
{
	// creating a method for launching browser
	@Test(priority = 0)
	public void launch() throws Throwable
	{
	
		// click on element tab and verify is it expanded
		 DemoQaHomePage dh=new DemoQaHomePage(driver);
		 dh.homePageElements();
	
		 
		// creating object of PomLogin to access the methods of that class and calling the methods
		RadioButtonPage rb = new RadioButtonPage(driver);
		rb.RadioButtonAndPage();
		rb.selectYesAndImpressiveButton();

	}
	 
}

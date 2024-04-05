package demoqaMain2812;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_templet.CommonTemplet;
import demoqaPages.DemoQaHomePage;
import demoqaPages.DemoqaFormsPage;

/**
 * Navigate to https://demoqa.com/ and select Elements
 * Expand the Forms menu bar and select Practice Form
 * Fill in the details under Student Registration Form and click on Submit
 * Verify form got submitted successfully
 * @author naresh.kummari
 *
 */
public class DemoqaTC1 extends CommonTemplet
{
		// creating a method for launching browser
		@Test
		public void fillForm() throws Throwable
		{
			

			// creating object of Demoqa home page to access the methods of that class and calling the methods
			DemoQaHomePage dh=new DemoQaHomePage(driver);
			dh.homePageForms();
		
			// creating object of Demoqa form page to access the methods of that class and calling the methods
			DemoqaFormsPage dp = new DemoqaFormsPage(driver);
			dp.setFirstName("naresh");
			dp.setlastName("kummari");
			dp.setuserEmail("nareshshalivahana1999@gmail.com");
			dp.setGenderMale();
			dp.setUserPhNumber("8397825953");
			dp.setDateOfBirth("1999",3,"2");
//			dp.setSubject("Maths");
			dp.setSubject("English");
			dp.setCurrentAddress("h-no:1-14");
			dp.setHobbieSport();
			dp.setPicture("C:\\Users\\naresh.kummari\\eclipse-workspace\\projectFramework2\\src\\test\\resources\\api.png", "api.png");
			dp.setState("Haryana");
			dp.setCity("Karnal");
			dp.clickOnSubmit();
			dp.verifydata();
			
		}
}

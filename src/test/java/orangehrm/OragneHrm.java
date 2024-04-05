package orangehrm;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commoc_methods.CommonMethods;
import common_templet.CommonTemplet;
import pagesOrangeHrm.DashBoard;
import pagesOrangeHrm.DirectoryPageAction;
import pagesOrangeHrm.LogoutHrm;
import pagesOrangeHrm.orangePomLogin;

/**
 * Login to the Application: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
 * Verify user logged into dashboard page successfully.
 * Click on Directory menu.
 * Enter the name: Linda, click on the directory suggestion "Linda Jane Anderson", select it and click on Search.
 * Validate the record displayed on page.
 * Click on profile icon and select Logout.
 * Validate user got logged out successfully.
 * @author naresh.kummari
 *
 */
public class OragneHrm extends CommonTemplet
{	
	@Test
  public void verifyEmployee() throws Throwable 
  {	
	  orangePomLogin po = new orangePomLogin(driver);
	  po.setUserName("admin");
	  po.setPassword("admin123");
	  po.clickOnLogin();
	
	  		// creating object of DashBoard to access the methods of that class and calling the methods
	  DashBoard db= new DashBoard(driver);
	  db.dashboardVerifyAndClickDirectory();
	
	  		// creating object of DirectoryPageAction to access the methods of that class and calling the methods
	  DirectoryPageAction Dp= new DirectoryPageAction(driver);
	  Dp.directorypageActions("Linda","EmployeeName","Linda Jane Anderson");
	
	  		// creating object of LogOut Hrm to access the methods of that class and calling the methods
	  LogoutHrm lo=new LogoutHrm(driver);
	  lo.logoutHrm();
  }
}

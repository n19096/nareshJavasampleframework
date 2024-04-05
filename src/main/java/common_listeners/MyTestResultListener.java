package common_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.relevantcodes.extentreports.LogStatus;

import commoc_methods.CommonMethods;

public class MyTestResultListener implements ITestListener {

//	WebDriver driver;
	CommonMethods co= new CommonMethods();

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		co.logger.info(result);
		co.test.log(LogStatus.PASS, "*** Executed " + result.getMethod().getMethodName() + " test successfully...");
	}
	public void onTestFailure(ITestResult result) {
		
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		co.logger.error(result);
		co.test.log(LogStatus.FAIL, "*** Test execution " + result.getName() + " failed..."+" Exception: "+result.getThrowable());
		co.test.log(LogStatus.FAIL, co.test.addScreenCapture(co.customScreenShot()));
		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		co.test.log(LogStatus.SKIP, "*** Test " + result.getSkipCausedBy() + " skipped...");
		co.logger.error(result);
		
	}
//	public void onException(Throwable throwable, WebDriver driver)
//	{
//	co.test.log(Status.SKIP, " "+driver.getMessage());
//	co.logger.error(" "+e.getMessage());
//	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}

package product_store_main;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import commoc_methods.CommonMethods;

import common_templet.CommonTemplet;
import product_store_pages.ProductStoreCartPage;
import product_store_pages.ProductStoreHomePage;
import product_store_pages.ProductStoreItemDetailsPage;
import product_store_pages.ProductStoreLoginPage;
//import product_store_pages.ProductStoreSignupPage;


public class ProductStoreMain17 extends CommonTemplet
{
	@Test
	public void addproduct() throws Throwable
	{
		fetchingPropertiesfile();
		// path of the folder
		String path="src\\test\\resources\\"+CommonMethods.prop.getProperty("Filename");
		//moving to that path
		FileInputStream inputdata = new FileInputStream(path);
		
		// Taking control of the file
		Workbook wb=WorkbookFactory.create(inputdata);
		
		// Taking control of the particular sheet sheet.getRow(i)
		Sheet sheet=wb.getSheet(CommonMethods.prop.getProperty("SheetName"));
		int k=sheet.getLastRowNum();
		for(int l=1;l<=k;l++) {
			ProductStoreHomePage productStoreHomePage= new ProductStoreHomePage(driver);
//			productStoreHomePage.signUplinkclickAction();
//			
//			ProductStoreSignupPage productStoreSignupPage = new ProductStoreSignupPage(driver);
//			productStoreSignupPage.signUpAction(l);
			
			ProductStoreLoginPage productStoreLoginPage = new ProductStoreLoginPage(driver);
			productStoreHomePage.logInlinkclickAction();
			productStoreLoginPage.logInAction(l);
			productStoreLoginPage.verifyUser();
			productStoreLoginPage.selectItem();
			
			ProductStoreItemDetailsPage productStoreItemDetailsPage=new ProductStoreItemDetailsPage(driver);
			productStoreItemDetailsPage.verifyItemDetailsPage();
			productStoreItemDetailsPage.verifyingItemInItemDetailsPage();
			productStoreItemDetailsPage.clickOnAddToCart();
			productStoreItemDetailsPage.popUpHandling();
			productStoreItemDetailsPage.clickOnCart();
			
			ProductStoreCartPage productStoreCartPage=new ProductStoreCartPage(driver);
			productStoreCartPage.cartPageAndItemVarifycation();
			productStoreCartPage.placeOrder(l);
			productStoreHomePage.logOutlinkclickAction();
	}}
}

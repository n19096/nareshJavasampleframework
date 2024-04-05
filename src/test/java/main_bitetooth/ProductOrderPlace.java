package main_bitetooth;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import bitetoothpastebits_pages.AllProductPage;
import bitetoothpastebits_pages.BundlesPage;
import bitetoothpastebits_pages.CommunityFavoritePage;
import bitetoothpastebits_pages.GiftSetsPage;
import bitetoothpastebits_pages.HomePage;
import bitetoothpastebits_pages.OralCarePage;
import bitetoothpastebits_pages.PersonalCarePage;
import common_templet.CommonTemplet;


/**
 * Navigate to the following website: https://bitetoothpastebits.com/
 * Select Shopping menu
 * Add random products to cart from different menus such as: All Products,  Oral care, Personal care, etc.
 * Continue to checkout and view the order summary
 * @author naresh.kummari
 *
 */
public class ProductOrderPlace extends CommonTemplet
{
	@Test
	public void multipleOrder() throws InterruptedException
	{
	// creating object of home page class to call non-static methods
	HomePage hp= new HomePage(driver);
	hp.closePopUp();
	AllProductPage pp= new AllProductPage(driver);
	pp.addProductsFromAllProducts();
	OralCarePage  cp = new OralCarePage(driver);
	cp.addProductsFromOralCare();
	PersonalCarePage pcp=new PersonalCarePage(driver);
	pcp.addProductsFromPersonalCare();
	BundlesPage bp = new BundlesPage(driver);
	bp.addProductsFromBundles();
	GiftSetsPage gsp= new GiftSetsPage(driver);
	gsp.addProductsFromGiftSets();
	CommunityFavoritePage cfp = new CommunityFavoritePage(driver);
	cfp.addProductsFromCommunityFavorite();
	hp.orderSummary();
	}
}

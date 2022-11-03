package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.AddToCartPage;
import com.ap.pages.HomePage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.pages.OrderPage;
import com.ap.pages.SearchResultPage;
import com.ap.testbase.TestBase;

public class OrderPageTest extends TestBase {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		launchApplication();
	}

	@Test
	public void verifyProductPrice() throws Exception {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.loginAction();
		searchresultpage = indexpage.searchproductButtonAction();
		addtocartpage = searchresultpage.clickOnProductAction();
		addtocartpage.enterQuantityAction();
		addtocartpage.selectSizeAction();
		addtocartpage.clickOnAddToCartButtonAction();
		Thread.sleep(5000);
		boolean text = addtocartpage.confirmationTextAction();
		Assert.assertTrue(text);
		orderpage = addtocartpage.proceedtocheckoutAction();
		Thread.sleep(5000);
		double unitprice = orderpage.getUnitPrice();
		double totalprice = orderpage.getTotalPrice();
		double totalExpectedPrice = (unitprice * 3) + 2;
		Assert.assertEquals(totalprice, totalExpectedPrice);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

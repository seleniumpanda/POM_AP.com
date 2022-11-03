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

public class AddToCartPageTest extends TestBase {

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
	public void addToCartTest() throws Exception {
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
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

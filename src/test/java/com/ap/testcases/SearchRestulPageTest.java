package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.HomePage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.pages.SearchResultPage;
import com.ap.testbase.TestBase;

public class SearchRestulPageTest extends TestBase {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		launchApplication();
	}

	@Test
	public void isProductAvailableTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.loginAction();
		searchresultpage = indexpage.searchproductButtonAction();
		boolean availability = searchresultpage.isProductAvailableAction();
		Assert.assertTrue(availability);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

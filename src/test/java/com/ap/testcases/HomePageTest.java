package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.pages.HomePage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.testbase.TestBase;

public class HomePageTest extends TestBase {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		launchApplication();
	}
	
	@Test
	public void wishlistbuttonvalidateTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.loginAction();
		boolean wish = homepage.wishlistbuttonvalidateAction();
		Assert.assertTrue(wish);
	}
	
	@Test
	public void orderhistorybuttonvalidateTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.loginAction();
		boolean wish1 = homepage.orderhistorybuttonvalidateAction();
		Assert.assertTrue(wish1);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

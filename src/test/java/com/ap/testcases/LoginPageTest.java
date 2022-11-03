package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.HomePage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.testbase.TestBase;

public class LoginPageTest extends TestBase {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		launchApplication();
    }

	@Test
	public void loginTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.loginAction();
		String actualCurrentUrl = homepage.getCurrentUrl();
		String expectedCurrentUrl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

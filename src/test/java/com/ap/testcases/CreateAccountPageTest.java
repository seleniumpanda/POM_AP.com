package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.pages.CreateAccountPage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.testbase.TestBase;

public class CreateAccountPageTest extends TestBase {

	IndexPage indexpage;
	LoginPage loginpage;
	CreateAccountPage createaccountpage;

	@BeforeMethod
	public void setup() {
		launchApplication();
	}

	@Test
	public void createNewAccountTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		createaccountpage = loginpage.createNewAccountAction();
		boolean create = createaccountpage.validatecreateAccountTitleAction();
		Assert.assertTrue(create);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

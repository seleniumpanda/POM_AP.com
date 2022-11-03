package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.pages.SearchResultPage;
import com.ap.testbase.TestBase;

public class IndexPageTest extends TestBase {
	IndexPage indexpage;
	LoginPage loginpage = new LoginPage();
	SearchResultPage searchresultpage = new SearchResultPage();

	@BeforeMethod
	public void setup() {
		launchApplication();

	}

	@Test(priority = 1)
	public void validatelogoIconTest() {
		indexpage = new IndexPage();
		boolean result = indexpage.validateLogoIcon();
		Assert.assertTrue(result);
	}

	@Test(priority = 2)
	public void validateIndexPageTitleTest() {
		String indexPageTitle = indexpage.validateIndexPageTitle();
		Assert.assertEquals(indexPageTitle, "My Store");
	}

	@Test(priority = 3)
	public void validateIndexPageCurrentUrlTest() {
		String indexPageCurrentUrl = indexpage.validateIndexPageCurrentUrl();
		Assert.assertEquals(indexPageCurrentUrl, "http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

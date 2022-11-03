package com.ap.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ap.pages.AddToCartPage;
import com.ap.pages.AddressPage;
import com.ap.pages.HomePage;
import com.ap.pages.IndexPage;
import com.ap.pages.LoginPage;
import com.ap.pages.OrderConfirmationPage;
import com.ap.pages.OrderPage;
import com.ap.pages.OrderSummaryPage;
import com.ap.pages.PaymentPage;
import com.ap.pages.SearchResultPage;
import com.ap.pages.ShippingPage;
import com.ap.testbase.TestBase;

public class OrderConfirmationPageTest extends TestBase{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	SoftAssert softassert;
	AddressPage addresspage;
	LoginPage loginpage;
	HomePage homepage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummarypage;
	OrderConfirmationPage orderconfirmationpage;

	@BeforeMethod
	public void setup() {
		launchApplication();
	}

	@Test
	public void orderConfirmationPageTest() throws Exception {
		softassert = new SoftAssert();
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
		softassert.assertTrue(text);
		orderpage = addtocartpage.proceedtocheckoutAction();
		Thread.sleep(5000);
		double unitprice = orderpage.getUnitPrice();
		double totalprice = orderpage.getTotalPrice();
		double totalExpectedPrice = (unitprice * 3) + 2;
		softassert.assertEquals(totalprice, totalExpectedPrice);
		addresspage = orderpage.clickonCheckout();

		shippingpage = addresspage.clickOnCheckOutAddressAction();
		boolean termsconditions = shippingpage.clickOnTermsAndConditionsAction();
		softassert.assertTrue(termsconditions);
 
		paymentpage = shippingpage.proceedtocheckoutshippingpageAction();
		
		boolean choosePayment = paymentpage.choosePaymentMethodTextAction();
		softassert.assertTrue(choosePayment);
		
		ordersummarypage = paymentpage.clickOnWirePayMentAction();
		orderconfirmationpage = ordersummarypage.clickOnConfirmMyOrderAction();
		
		boolean flag = orderconfirmationpage.orderconfirmationLogoValidationAction();
		softassert.assertTrue(flag);
		
		String expectedText = orderconfirmationpage.messageconfirmationfromMyStoreAction();
		String actualText = "Your order on My Store is complete.";
		
		softassert.assertEquals(expectedText, actualText);
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

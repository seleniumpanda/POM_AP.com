package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class PaymentPage extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(), 'Please choose your payment method')]")
	WebElement pleasechooseyourpaymentMethodText;
	
	@FindBy(className = "bankwire")
	WebElement payByBankWirePaymentMethod;
	
	@FindBy(className = "cheque")
	WebElement payByCheckPaymentMethod;
	

	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean choosePaymentMethodTextAction() {
		return pleasechooseyourpaymentMethodText.isDisplayed();
	}
	
	public OrderSummaryPage clickOnWirePayMentAction() {
		payByBankWirePaymentMethod.click();
		return new OrderSummaryPage();
	}

}

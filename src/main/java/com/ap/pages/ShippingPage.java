package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ap.testbase.TestBase;

public class ShippingPage extends TestBase{
	
	@FindBy(id = "cgv")
	WebElement checkboxTermsAndConditions;
	
	@FindBy(name = "processCarrier")
	WebElement proceedToCheckOutShippingButton;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnTermsAndConditionsAction() {
		checkboxTermsAndConditions.click();
		return checkboxTermsAndConditions.isSelected();
	}
	
	public PaymentPage proceedtocheckoutshippingpageAction() {
		proceedToCheckOutShippingButton.click();
		return new PaymentPage();
	}

}

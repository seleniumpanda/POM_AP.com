package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class AddressPage extends TestBase{
	
	@FindBy(name = "processAddress")
	WebElement proceedtoCheckOutAddress;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ShippingPage clickOnCheckOutAddressAction() {
		proceedtoCheckOutAddress.click();
		return new ShippingPage();
	}
	
	

}

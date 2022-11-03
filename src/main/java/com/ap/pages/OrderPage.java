package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class OrderPage extends TestBase {
	
	@FindBy(xpath = "//td[@class = 'cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totolPrice;
	
	@FindBy(css = "a.button.btn.btn-default.standard-checkout.button-medium")
	WebElement proceedToCheckOutButton;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String resultunit = unitPrice.getText();
		String finalunit = resultunit.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitPrice = Double.parseDouble(finalunit);
		return finalunitPrice/100;
		
	}
	
	public double getTotalPrice() {
		String resultTotal = totolPrice.getText();
		String finalTotal = resultTotal.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(finalTotal);
		return finalTotalPrice/100;
		
	}
	
	public AddressPage clickonCheckout() {
		proceedToCheckOutButton.click();
		return new AddressPage();
	}
	
	

}

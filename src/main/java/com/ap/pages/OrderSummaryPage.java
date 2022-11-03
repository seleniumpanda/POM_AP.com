package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class OrderSummaryPage extends TestBase {

	@FindBy(css = "button.button.btn.btn-default.button-medium")
	WebElement iConfirmMyOrderButton;

	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage clickOnConfirmMyOrderAction() {
		iConfirmMyOrderButton.click();
		return new OrderConfirmationPage();

	}

}

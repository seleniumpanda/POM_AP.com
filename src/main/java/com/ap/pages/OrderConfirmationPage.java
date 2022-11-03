package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class OrderConfirmationPage extends TestBase{
	
	@FindBy(xpath = "//span[@class = 'navigation_page'][contains(text(), 'Order confirmation')]")
	WebElement orderconfirmationLogo;
	
	@FindBy(xpath = "//strong[@class = 'dark'][contains(text(), 'Your order on My Store is complete.')]")
	WebElement messageConfirmationMyStoreComplete;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean orderconfirmationLogoValidationAction() {
		return orderconfirmationLogo.isDisplayed();
	}
	
	public String messageconfirmationfromMyStoreAction() {
	String flag =  messageConfirmationMyStoreComplete.getText();
	return flag;
	}
	
	

}

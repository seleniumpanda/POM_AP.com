package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css = "i.icon-heart + span")
	WebElement MyWishListsButton;
	
	@FindBy(css = "i.icon-list-ol + span")
	WebElement orderHistoryandDetailsButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean wishlistbuttonvalidateAction() {
		return MyWishListsButton.isDisplayed();	
	}
	
	public boolean orderhistorybuttonvalidateAction() {
		return orderHistoryandDetailsButton.isDisplayed();
	}
	
	public String getCurrentUrl() {
		String homePageCurrentUrl = driver.getCurrentUrl();
		return homePageCurrentUrl;
	}

}

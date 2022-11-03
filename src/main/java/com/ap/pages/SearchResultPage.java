package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class SearchResultPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailableAction() {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProductAction() {
		productResult.click();
		return new AddToCartPage();
	}

}

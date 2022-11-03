	package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class IndexPage extends TestBase{
	
	@FindBy(className = "login")
	WebElement signInLink;
	
	@FindBy(css = "img.logo.img-responsive")
	WebElement LogoIcon;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchProductButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		signInLink.click();
		return new LoginPage();
	}
	
	public boolean validateLogoIcon() {
		return LogoIcon.isDisplayed();
	}
	
	public String validateIndexPageTitle() {
		return driver.getTitle();
	}
	
	public String validateIndexPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean searchproductbox() {
		return (searchProductBox.isEnabled() && searchProductBox.isDisplayed());
	}
	
	public SearchResultPage searchproductButtonAction() {
		searchProductBox.sendKeys("T Shirts");
		searchProductButton.click();
		return new SearchResultPage();
	}
	
	
}

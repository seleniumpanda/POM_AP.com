package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ap.testbase.TestBase;

public class CreateAccountPage extends TestBase {
	
	@FindBy(xpath = "//h1[text() = 'Create an account']")
	WebElement createAccountTitleText;
	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validatecreateAccountTitleAction() {
		return createAccountTitleText.isDisplayed();
	}

}

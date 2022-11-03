package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signinButton;

	@FindBy(name = "email_create")
	WebElement emailforNewAccount;

	@FindBy(name = "SubmitCreate")
	WebElement createNewAccountButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccountPage createNewAccountAction() {
		emailforNewAccount.sendKeys(prop.getProperty("newemail"));
		createNewAccountButton.click();
		return new CreateAccountPage();
	}

	public HomePage loginAction() {
       username.sendKeys(prop.getProperty("username"));
       password.sendKeys(prop.getProperty("password"));
       signinButton.click();
       return new HomePage();
	}

}

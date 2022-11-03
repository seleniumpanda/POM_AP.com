package com.ap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.testbase.TestBase;

public class AddToCartPage extends TestBase{
	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text() = 'Add to cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//span[@class = 'cross']/following-sibling::h2[1]")
	WebElement addedProductConfirmationText;
	
	@FindBy(css = "a.btn.btn-default.button.button-medium")
	WebElement proceedToCheckOutButton;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantityAction() {
		quantity.sendKeys("1");
	}
	
	public void selectSizeAction() {
		Select select = new Select(driver.findElement(By.id("group_1")));
		select.selectByVisibleText("L");
	}
	
	public boolean clickOnAddToCartButtonAction() {
		addToCartButton.click();
		return addedProductConfirmationText.isDisplayed();
	}
	
	public OrderPage proceedtocheckoutAction() {
		proceedToCheckOutButton.click();
		return new OrderPage();
	}
	
	public boolean confirmationTextAction() {
		return addedProductConfirmationText.isDisplayed();
	}
	
	

}

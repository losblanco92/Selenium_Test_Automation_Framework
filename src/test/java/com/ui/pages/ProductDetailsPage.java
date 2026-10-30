package com.ui.pages;

import java.security.KeyStore.PrivateKeyEntry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By SIZE_SELECTOR_DROPDOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BTN_LOCATOR = By.xpath("//span[contains(text(),'Add')]/..");
	private static final By CHECKOUT_BTN_LOCATOR = By.xpath("//span[contains(text(),'Proceed')]/..");

	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public OrderPage addToCart (String option)
	{
		
		By optionLocator = By.xpath(String.format("//option[text()='%s']", option));
		
		selectValueFromDropDown(SIZE_SELECTOR_DROPDOWN_LOCATOR, optionLocator);
		clickOn(ADD_TO_CART_BTN_LOCATOR);
		clickOn(CHECKOUT_BTN_LOCATOR);
		return new OrderPage(getDriver());
		
		
	}

}

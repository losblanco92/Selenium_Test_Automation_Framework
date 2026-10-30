package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderPage extends BrowserUtility {

	private static final By CHECKOUT_BTN_LOCATOR = By.xpath("//p[contains(@class,'clearfix')]//span/..");
	
	private static final By CHECK_BOX_LOCATOR = By.cssSelector("label[for='cgv']");
	private static final By ALERT_LOCATOR = By.xpath("//p[contains(@class,'alert-warning')]");

	public OrderPage(WebDriver driver) {
		super(driver);

	}

	public String checkOut() {

		clickOn(CHECKOUT_BTN_LOCATOR);
		clickOn(CHECKOUT_BTN_LOCATOR);
        
		clickOnCheckBox(CHECK_BOX_LOCATOR);
	
		clickOn(CHECKOUT_BTN_LOCATOR);
		return getVisibleText(ALERT_LOCATOR);

	}

}

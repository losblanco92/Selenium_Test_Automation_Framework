package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	public LoginPage(WebDriver driver) {
		super(driver);
	}



	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BTN_LOCATOR = By.id("SubmitLogin");

	

	public MyAccountPage doLoginWith(String email, String password) {

		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);

		return new MyAccountPage(getDriver());
	}

}
